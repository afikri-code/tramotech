module de.tramotech.tools.texteditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires utils;

    exports de.tramotech.tools.texteditor;
    opens de.tramotech.tools.texteditor to javafx.fxml;
}