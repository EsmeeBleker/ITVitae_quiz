package com.group.quiz;

import Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FxController {

    private final ViewController viewController;


    @FXML
    private Label questionLabel;
    @FXML
    private Label answerLabel;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;

    public FxController() {
        viewController = new ViewController(this);
    }

    @FXML
    protected void onNextButtonClick() {
        viewController.onButtonNextClick();
    }
    @FXML
    public void setText(String question) {
        questionLabel.setText(question);
    }
    @FXML
    public void setTextButtonA(String answer) {
        buttonA.setText(answer);
    }

    public void setTextButtonB(String answer) {
        buttonB.setText(answer);
    }

    public void setTextButtonC(String answer) {
        buttonC.setText(answer);
    }

    public void setTextButtonD(String answer) {
        buttonD.setText(answer);
    }
}