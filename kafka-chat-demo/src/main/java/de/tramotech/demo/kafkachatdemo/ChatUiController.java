package de.tramotech.demo.kafkachatdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatUiController {
    @FXML
    private TextArea mainArea;
    @FXML
    private TextField input;

    private KafkaClient kafka = KafkaClient.getInstance();
    @FXML
    protected void onHelloButtonClick() {
        kafka.sendMessage(input.getText());
        input.clear();

    }
}