package de.tramotech.tools.texteditor;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {

    File selectedFile;
    String title = "untitled";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("texteditor.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 620, 440);

        // Create a TextArea
        TextArea textArea = (TextArea) fxmlLoader.getNamespace().get("content");
// Add a change listener to the text property of the TextArea
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                stage.setTitle(stage.getTitle()+"*");
                // Perform any actions you need with the new text
            }
        });

        // Get a reference to the "Open..." MenuItem
        MenuItem openMenuItem = (MenuItem) fxmlLoader.getNamespace().get("openMenuItem");
        // Get a reference to the "Open..." MenuItem
        MenuItem saveMenuItem = (MenuItem) fxmlLoader.getNamespace().get("saveMenuItem");

        scene.setOnKeyPressed(event -> {
            if (event.isShortcutDown() && event.getCode() == KeyCode.S) {
                // The Command (Ctrl) key and "S" key were pressed simultaneously
                if(selectedFile == null){
                    // Create a FileChooser
                    FileChooser fileChooser = new FileChooser();

                    // Set the title of the FileChooser dialog
                    fileChooser.setTitle("Save File");
                    selectedFile = fileChooser.showSaveDialog(stage);
                    stage.setTitle(selectedFile.getName());
                }

                saveStringToFile(textArea.getText(), selectedFile);
                stage.setTitle(selectedFile.getName());
            }
        });

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
                    stage.setTitle(selectedFile.getName());

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
                    fileChooser.setTitle("Save File");
                    selectedFile = fileChooser.showSaveDialog(stage);
                    stage.setTitle(selectedFile.getName());
                }

                saveStringToFile(textArea.getText(), selectedFile);
                stage.setTitle(selectedFile.getName());
            }
        });


        stage.setTitle(title);
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