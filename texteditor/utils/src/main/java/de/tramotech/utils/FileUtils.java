package de.tramotech.utils;

import java.io.*;
import java.nio.charset.Charset;

/**
 *
 *
 */
public class FileUtils
{
    public static String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            //BufferedReader reader = new BufferedReader(new FileReader(filePath)));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Charset.forName("ISO-8859-1")));

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void saveStringToFile(String text, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file, Charset.forName("ISO-8859-1"));

            // Write the text to the file
            fileWriter.write(text);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here, e.g., show an error dialog
        }
    }
}
