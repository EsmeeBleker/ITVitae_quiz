package com.group.quiz;

import Controller.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FxController implements Initializable {

    public ViewController viewController;

    public FxController() {
        viewController = new ViewController(this);
        //openscene = new OpenScene();
    }

    public void changeScene(Stage window, String name) throws Exception{
        FXMLLoader fxmlloader = new FXMLLoader((Main.class.getResource(name)));
/*        FxController controller = fxmlloader.getController();
        viewController.setFxController(controller);*/
        Scene endScene = new Scene(fxmlloader.load(), 400, 380);
        window.setScene(endScene);
        window.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        // do nothing
    }

    public void namescreenOkButtonClick(String name){
        viewController.setName(name);
    }

    public void quizscreenNextButtonClick() throws Exception {
        viewController.onButtonNextClick();
    }

    public void quizscreenSetQuestionText(String question) {//to override
    }

    public void quizscreenSetTextButton(String[] answers) {// to override
    }

    protected void quizscreenGetMaxQuestions(String maxQuestions) {viewController.setMaxQuestions(maxQuestions);
    }

    protected void quizscreenAButtonClick(int i) {viewController.buttonClicked(1);
    }

    protected void quizscreenOkButtonClick() {
        viewController.onButtonOkClick();
        viewController.getName();
    }

    public void quizscreenSetNameLabel(String name){
        // to override
    }

    public void quizscreenSetAnswerLabel(String text){
        // to override
    }

    public void quizscreenButtonColour(boolean[] bool){
        //to override
    }

    public void quizscreenUpdateScore(String scr) {
        //to override
    }

    public void quizscreenSetProgess(int i, String maxQuestions) {
        //to override
    }

    public void quizscreenSetFinalScreen() throws Exception {
        // to override
    }

    public void endscreenSetScoreAndText(int score, String maxQuestions, String wellDoneText){
        // to override
    }

    protected void resetGame() {
        viewController.resetGame();
    }

}