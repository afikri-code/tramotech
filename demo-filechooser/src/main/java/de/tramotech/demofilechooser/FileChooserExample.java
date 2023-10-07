package de.tramotech.demofilechooser;

import javafx.application.Application;
        import javafx.stage.FileChooser;
        import javafx.stage.Stage;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.VBox;

import java.io.File;

/**
 * Author: Ahmed Fikri
 */
public class FileChooserExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Chooser Example");

        // Create a VBox to hold the button
        VBox vbox = new VBox(10);
        vbox.setMinSize(300, 200);

        // Create a button to open the file chooser dialog
        Button openButton = new Button("Open File Chooser");

        // Create a file chooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))); // Initial directory
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Add an event handler to the button
        openButton.setOnAction(e -> {
            // Show the file chooser dialog and get the selected file
            java.io.File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                System.out.println("Selected File: " + selectedFile.getAbsolutePath());
                // You can perform further actions with the selected file here
            }
        });

        vbox.getChildren().add(openButton);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}