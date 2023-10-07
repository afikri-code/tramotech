module de.tramotech.tools.texteditor2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports de.tramotech.tools.texteditor;
    opens de.tramotech.tools.texteditor to javafx.fxml;
}