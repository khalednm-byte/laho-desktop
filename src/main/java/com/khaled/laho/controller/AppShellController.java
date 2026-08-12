package com.khaled.laho.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class AppShellController {

    @FXML
    private StackPane contentPane;

    @FXML
    private void showStore() {
        showPage("Store");
    }

    @FXML
    private void showLibrary() {
        showPage("Library");
    }

    private void showPage(String pageName) {
        contentPane.getChildren().setAll(new Label(pageName));
    }
}