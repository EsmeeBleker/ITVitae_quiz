package Controller;

import com.group.quiz.FxController;

public class ViewController {
    private final ModelController modelController;
    private final FxController fxController;

    public ViewController(FxController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
        
    }

    public void onButtonNextClick() {
        modelController.incrementQuestion();
        modelController.getQuestion();
    }

    public void setQuestion(String question) {
        fxController.setQuestionText(question);
    }

    public void setAnswer(String[] answers) {
        fxController.setTextButton(answers);
    }

    public void buttonClicked(int i) {
        modelController.checkAnswer(i);
    }

    public void checkAnswer(boolean correct) {
        String text;
        if (correct){
            text = "Your answer is correct";
        }
        else{
            text = "Your answer is incorrect";
        }
        fxController.setAnswerLabel(text);
    }

    public void colourButton(boolean[] bool) {
        fxController.ButtonColour(bool);
    }

    public void updateScore(int score) {
        String scr = String.valueOf(score);
        fxController.updateScore(scr);
    }

    public void setName(String name) {
        modelController.setName(name);
    }

    public void onButtonOkClick() {
        modelController.fillArray();
        modelController.getQuestion();
    }
}
