module arabSteam {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    opens model to javafx.fxml;  // if you're using FXML with controllers in this package
    exports model;
}