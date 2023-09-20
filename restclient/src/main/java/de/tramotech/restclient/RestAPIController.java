package de.tramotech.restclient;

import de.tramotech.RestClient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class RestAPIController {

    private final Map<String, HttpMethod> httpMethodMap = new HashMap<>();
    @FXML
    private ComboBox<String> httpMethodComboBox;
    @FXML
    private TextArea inputArea;
    @FXML
    private TextArea outputArea;
    @FXML
    private TextField baseUrl;
    @FXML
    private TextField endpoint;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button sendData;

    public void initialize() {
        httpMethodMap.put("GET", HttpMethod.GET);
        httpMethodMap.put("POST", HttpMethod.POST);
        httpMethodMap.put("PUT", HttpMethod.PUT);
        httpMethodMap.put("DELETE", HttpMethod.DELETE);

        // Add elements to the ComboBox
        httpMethodComboBox.getItems().addAll("GET", "POST", "PUT", "DELETE");
        // You can also set a default value
        httpMethodComboBox.setValue("GET");
        baseUrl.setText("http://localhost:8080");
    }
    @FXML
    private void onSendButtonClick() {
        // Read data from inputArea and copy it to outputArea
        String inputData = inputArea.getText();
        String selectedMethod = httpMethodComboBox.getValue();
        try {
            RestClient client = new RestClient(baseUrl.getText());

            // Add credentials if needed
            client.addCredentials(username.getText(), password.getText());

            String jsonResponse = client.executeRequest(endpoint.getText(), httpMethodMap.get(selectedMethod), inputData);
            outputArea.setText(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}