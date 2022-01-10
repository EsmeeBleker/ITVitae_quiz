package Controller;

import com.group.quiz.FxController;

public class ViewController {
    private final ModelController modelController;
    private FxController fxController;

    public ViewController(FxController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
    }

    public void onButtonNextClick() throws Exception {
        if (modelController.isLastQuestion()) {
            modelController.getScore();
        } else {
            modelController.incrementQuestion();
            modelController.getQuestion();
        }
    }

    public void setQuestion(String question) {
        fxController.quizscreenSetQuestionText(question);
    }

    public void setAnswer(String[] answers) {
        fxController.quizscreenSetTextButton(answers);
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
        fxController.quizscreenSetAnswerLabel(text);
    }

    public void colourButton(boolean[] bool) {
        fxController.quizscreenButtonColour(bool);
    }

    public void updateScore(int score) {
        String scr = String.valueOf(score);
        fxController.quizscreenUpdateScore(scr);
    }

    public void setName(String name)
    {
        if (name.isEmpty() == false){
            modelController.setName(name);
        }
    }

    public void onButtonOkClick() {
        modelController.makeQuestionArray();
        modelController.getQuestion();
    }

    public void setProgress(int vraagNr, String maxQuestions) {
        fxController.quizscreenSetProgess(vraagNr + 1, maxQuestions);
    }

    public void setMaxQuestions(String maxQuestions) {
        modelController.buildURL(maxQuestions);
    }

    public void setFinalScreen(int score, String maxQuestions) throws Exception {
        int max = Integer.parseInt(maxQuestions);
        String wellDoneText;
        if (score / max < 0.5){
            wellDoneText = "Better luck next time!";
        }
        else if (score / max < 0.8){
            wellDoneText = "Well done!";
        }
        else if (score / max < 1){
            wellDoneText = "Excellent work!";
        }
        else{
            wellDoneText = "Congratulations, you got all questions correct!";
        }
        fxController.quizscreenSetFinalScreen();
        fxController.endscreenSetScoreAndText(score, maxQuestions, wellDoneText);
    }

    public void resetGame() {
        modelController.resetGame();
    }

    public void getName() {
        modelController.getName();
    }

    public void returnName(String name) {
    fxController.quizscreenSetNameLabel(name);
    }
}
