package de.tramotech.tools.texteditor;

import de.tramotech.utils.FileUtils;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class HelloApplication extends Application {

    File selectedFile;
    String title = "untitled";
    void setTitle(Stage stage) {

        if(selectedFile == null) {
         stage.setTitle("untitled*");
         return;
        }
        stage.setTitle(selectedFile.getName() + "*");
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("texteditor.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 920, 440);

        // Create a TextArea
        TextArea textArea = (TextArea) fxmlLoader.getNamespace().get("content");
// Add a change listener to the text property of the TextArea
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setTitle(stage);
                // Perform any actions you need with the new text
            }
        });

        // Get a reference to the "Open..." MenuItem
        MenuItem openMenuItem = (MenuItem) fxmlLoader.getNamespace().get("openMenuItem");
        // Get a reference to the "Open..." MenuItem
        MenuItem saveMenuItem = (MenuItem) fxmlLoader.getNamespace().get("saveMenuItem");

        scene.setOnKeyPressed(event -> {
            if (event.isShortcutDown() && event.getCode() == KeyCode.S) {
                saveFile(stage, textArea);
                return;
            }
            if (event.isShortcutDown() && event.getCode() == KeyCode.O) {

                openFile(stage, textArea);
            }
        });

        // Add an event handler to the "Open..." MenuItem
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openFile(stage, textArea);
            }
        });

        // Add an event handler to the "Open..." MenuItem
        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                saveFile(stage, textArea);
            }
        });

        textArea.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Get the current text content
                String text = textArea.getText();
                int caretPosition = textArea.getCaretPosition();

                // Find the position of the last newline character
                int lastNewline = text.lastIndexOf('\n', caretPosition - 1);

                if (lastNewline >= 0) {
                    // Find the position of the newline character before the last newline character
                    int lineStart = text.lastIndexOf('\n', lastNewline - 1);

                    if (lineStart >= 0) {
                        String previousLine = text.substring(lineStart + 1, lastNewline);

                        // Count the leading spaces or tabs in the previous line
                        int indentLength = 0;
                        for (char c : previousLine.toCharArray()) {
                            if (c == ' ' || c == '\t') {
                                indentLength++;
                            } else {
                                break;
                            }
                        }

                        // Add the same indentation to the new line
                        textArea.insertText(caretPosition, " ".repeat(indentLength));
                        textArea.positionCaret(caretPosition + indentLength);
                    }
                }
            }
        });



        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }



    void saveFile(Stage stage, TextArea textArea) {
        // The Command (Ctrl) key and "S" key were pressed simultaneously
        if(selectedFile == null){
            // Create a FileChooser
            FileChooser fileChooser = new FileChooser();

            // Set the title of the FileChooser dialog
            fileChooser.setTitle("Save File");
            selectedFile = fileChooser.showSaveDialog(stage);
            stage.setTitle(selectedFile.getName());
        }

        FileUtils.saveStringToFile(textArea.getText(), selectedFile);
        stage.setTitle(selectedFile.getName());
    }

    void openFile(Stage stage, TextArea textArea) {
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
            textArea.setText(FileUtils.readFileToString(filePath));
            stage.setTitle(selectedFile.getName());

            // Add your code to open and process the selected file here
        } else {
            // The user canceled the file selection
            System.out.println("File selection canceled.");
        }

    }
    public static void main(String[] args) {
        launch();
    }
}