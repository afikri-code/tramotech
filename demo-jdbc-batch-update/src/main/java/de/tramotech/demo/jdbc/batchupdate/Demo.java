package de.tramotech.demo.jdbc.batchupdate;

import java.sql.*;

public class Demo
{
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=testDB";
    static final String USER = "demo";
    static final String PASS = "t3stUser";
    static final String SELECT_QUERY = "SELECT id, text FROM demo_batch_update";
    static final String UPDATE_STATEMENT = "update  demo_batch_update set text = ? where id = ?";

    static String transformText(String text) {
        if(text == null)
            return null;
        return text.toUpperCase();
    }

    static void firstApproach() throws Exception {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try(Statement readData = conn.createStatement()){
                try(ResultSet rs = readData.executeQuery(SELECT_QUERY)){
                    while(rs.next()){
                        long id = rs.getLong(1);
                        String text = rs.getString(2);
                        try(PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_STATEMENT)) {
                            preparedStatement.setString(1, transformText(text));
                            preparedStatement.setLong(2, id);
                            preparedStatement.executeUpdate();
                        }
                    }
                    conn.commit();
                }

            }
        }
    }

    static void secondApproach() throws Exception {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS  )) {
            try(Statement readData = conn.createStatement()) {
                conn.setAutoCommit(false);
                try (PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_STATEMENT)) {
                    try (ResultSet rs = readData.executeQuery(SELECT_QUERY)) {
                        while (rs.next()) {
                            long id = rs.getLong(1);
                            String text = rs.getString(2);

                            preparedStatement.setString(1, transformText(text));
                            preparedStatement.setLong(2, id);
                            preparedStatement.addBatch();
                        }
                        System.out.println("start execute batch");
                        preparedStatement.executeBatch();
                        }
                    }
                conn.commit();
                }
            }
        }

    static void thirdApproach() {
        /*
           1) insert the change in a staging table
           2) use batch insert
           3) with one statement merge the staging table into the target table
         */
    }


    public static void main( String[] args ) throws Exception
    {
        System.out.println( "start" );
        Long elapsedTime = System.nanoTime();
        secondApproach();
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.printf("Update took %d (ms) \n",elapsedTime/1000_000L);

    }
}



