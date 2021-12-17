package com.group.quiz;

import Controller.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FxController implements Initializable {

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
    @FXML
    private Button buttonOK;
    @FXML
    private Label nameLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private TextField nameField;
    @FXML
    private Label progressLabel;
    @FXML
    private ChoiceBox<String> maxQuestionsBox;
    private String[] choices = {"5", "10", "15", "20", "30", "40", "50"};

    public FxController() {
        viewController = new ViewController(this);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        maxQuestionsBox.getItems().addAll(choices);
        maxQuestionsBox.setOnAction(this::getMaxQuestions);
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

    public void getMaxQuestions(ActionEvent event){
        String maxQuestions = maxQuestionsBox.getValue();
        viewController.setMaxQuestions(maxQuestions);
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
    public void onOKbuttonClick(){
        String name = nameField.getText();
        viewController.setName(name);
        viewController.onButtonOkClick();
        enableButtons();
        nameLabel.setText(name);
        nameField.setDisable(true);
        nameField.setVisible(false);
        nameLabel.setVisible(true);
        scoreLabel.setVisible(true);
        buttonNext.setVisible(true);
        buttonNext.setDisable(true);
        buttonOK.setDisable(true);
        buttonOK.setVisible(false);
    }

    public void setAnswerLabel(String text) {
        answerLabel.setText(text);
    }


    public void ButtonColour(boolean[] bool) {
        Button[] buttons = new Button[] {buttonA, buttonB, buttonC, buttonD};
        for (int i = 0; i < 4; i++){
            if (bool[i]){
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
        answerLabel.setVisible(true);

    }

    public void enableButtons(){
        Button[] buttons = new Button[] {buttonA, buttonB, buttonC, buttonD};
        for (Button button : buttons) {
            button.setStyle("-fx-background-color: #dcdcdc; ");
            button.setDisable(false);
            button.setVisible(true);
        }
        buttonNext.setDisable(true);
        answerLabel.setVisible(false);
    }

    public void updateScore(String scr) {
        scoreLabel.setText("Score: " + scr);
    }

    public void setProgess(int i) {
        progressLabel.setText("Vraag: " + i);
    }
}