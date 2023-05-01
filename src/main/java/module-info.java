module com.example.simpleuniversitylibrarysystemgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.simpleuniversitylibrarysystemgui to javafx.fxml;
    exports com.example.simpleuniversitylibrarysystemgui;
}