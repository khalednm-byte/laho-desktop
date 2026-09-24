module com.khaled.laho {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    exports com.khaled.laho.app;
    opens com.khaled.laho.controller to javafx.fxml;
    opens com.khaled.laho.model to com.fasterxml.jackson.databind;
}