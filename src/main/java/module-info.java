module com.khaled.laho {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.khaled.laho.app;
    opens com.khaled.laho.controller to javafx.fxml;
}