module de.tramotech.restclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires restapilib;
    requires spring.web;

    opens de.tramotech.restclient to javafx.fxml;
    exports de.tramotech.restclient;
}