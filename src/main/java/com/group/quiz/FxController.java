package com.group.quiz;

import Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FxController {

    private final ViewController viewController;


    @FXML
    private Label welcomeText;

    public FxController() {
        viewController = new ViewController(this);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}