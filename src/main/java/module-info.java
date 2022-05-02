module com.example.firstapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.firstApp to javafx.fxml;
    exports com.example.firstApp;
}