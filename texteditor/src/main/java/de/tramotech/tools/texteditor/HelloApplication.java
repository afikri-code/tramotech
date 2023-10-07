package de.tramotech.tools.texteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {

    File selectedFile;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("texteditor.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 620, 440);

        // Create a TextArea
        TextArea textArea = (TextArea) fxmlLoader.getNamespace().get("content");


        // Get a reference to the "Open..." MenuItem
        MenuItem openMenuItem = (MenuItem) fxmlLoader.getNamespace().get("openMenuItem");
        // Get a reference to the "Open..." MenuItem
        MenuItem saveMenuItem = (MenuItem) fxmlLoader.getNamespace().get("saveMenuItem");

        // Add an event handler to the "Open..." MenuItem
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Create a FileChooser
                FileChooser fileChooser = new FileChooser();

                // Set the title of the FileChooser dialog
                fileChooser.setTitle("Open File");

                // Show a FileChooser dialog to open a file
                selectedFile = fileChooser.showOpenDialog(stage);

                // Check if a file was selected
                if (selectedFile != null) {
                    // Implement your logic for opening the selected file here
                    // For example, you can display the file path or perform further operations
                    String filePath = selectedFile.getAbsolutePath();
                    textArea.setText(readFileToString(filePath));
                    System.out.println("Selected File: " + filePath);

                    // Add your code to open and process the selected file here
                } else {
                    // The user canceled the file selection
                    System.out.println("File selection canceled.");
                }
            }
        });

        // Add an event handler to the "Open..." MenuItem
        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(selectedFile == null){
                    // Create a FileChooser
                    FileChooser fileChooser = new FileChooser();

                    // Set the title of the FileChooser dialog
                    fileChooser.setTitle("Open File");
                    selectedFile = fileChooser.showSaveDialog(stage);
                }
               saveStringToFile(textArea.getText(), selectedFile);
            }
        });


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


  static void saveStringToFile(String text, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);

            // Write the text to the file
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here, e.g., show an error dialog
        }
    }

    static String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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







    public static void main(String[] args) {
        launch();
    }
}