package Controller;

import Model.Antwoord;
import com.group.quiz.FxController;

public class ViewController {
    private final ModelController modelController;
    private final FxController fxController;

    public ViewController(FxController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
        
    }

    public void onButtonNextClick() {
        modelController.getQuestion();
    }

    public void setQuestion(String question) {
        fxController.setText(question);
    }

    public void setAnswer(String[] answers) {
        fxController.setTextButtonA(answers[0]);
        fxController.setTextButtonB(answers[1]);
        fxController.setTextButtonC(answers[2]);
        fxController.setTextButtonD(answers[3]);
    }

}
