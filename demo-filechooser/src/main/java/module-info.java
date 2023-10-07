module de.tramotech.demofilechooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.tramotech.demofilechooser to javafx.fxml;
    exports de.tramotech.demofilechooser;
}