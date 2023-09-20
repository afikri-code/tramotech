package de.tramotech.restclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RestAPIClient extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RestAPIClient.class.getResource("restapiclient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        stage.setTitle("REST API Client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}