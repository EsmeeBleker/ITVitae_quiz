package com.group.quiz;

import Controller.ViewController;
import javafx.event.ActionEvent;
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
    @FXML
    private Button buttonNext;

    public FxController() {
        viewController = new ViewController(this);
    }

    @FXML
    protected void onNextButtonClick() {
        viewController.onButtonNextClick();
        enableButtons();
    }
    @FXML
    public void setQuestionText(String question) {
        questionLabel.setText(question);
    }
    @FXML
    public void setTextButton(String[] answers) {
        buttonA.setText(answers[0]);
        buttonB.setText(answers[1]);
        buttonC.setText(answers[2]);
        buttonD.setText(answers[3]);
    }

    public void onAButtonClick() {
        viewController.buttonClicked(1);
        disableButtons();
    }

    public void onBButtonClick() {
        viewController.buttonClicked(2);
        disableButtons();
    }

    public void onCButtonClick() {
        viewController.buttonClicked(3);
        disableButtons();
    }

    public void onDButtonClick() {
        viewController.buttonClicked(4);
        disableButtons();
    }

    public void setAnswerLabel(String text) {
        answerLabel.setText(text);
    }

    public void ButtonColour(boolean[] bool) {
        Button[] buttons = new Button[] {buttonA, buttonB, buttonC, buttonD};
        for (int i = 0; i < 4; i++){
            if (bool[i] == true){
                buttons[i].setStyle("-fx-background-color: #06d21e; ");
            }
            else{
                buttons[i].setStyle("-fx-background-color: #ff0000; ");
            }
        }
    }

    public void disableButtons(){
        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonNext.setDisable(false);

    }

    public void enableButtons(){
        buttonA.setDisable(false);
        buttonB.setDisable(false);
        buttonC.setDisable(false);
        buttonD.setDisable(false);
        buttonNext.setDisable(true);
        buttonA.setStyle("-fx-background-color: #dcdcdc; ");
    }
}