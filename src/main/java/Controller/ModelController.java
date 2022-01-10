package Controller;
import Model.*;



public class ModelController {
    private final ViewController viewController;
    Model model = new Model();

    public ModelController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void getQuestion() {
        //Vraag vraag1 = model.createQuestion(); //(Wisselende vraag)
        int vraagnr = model.getVraagNr();
        Vraag vraag1 = model.getQuestionFromVragenArray(vraagnr);
        String[] answers = new String[4];
        answers[0] = vraag1.antwoord1.getAntwoord();
        answers[1] = vraag1.antwoord2.getAntwoord();
        answers[2] = vraag1.antwoord3.getAntwoord();
        answers[3] = vraag1.antwoord4.getAntwoord();
        viewController.setQuestion(vraag1.question);
        viewController.setAnswer(answers);
        viewController.setProgress(model.getVraagNr(), model.getMaxQuestions());
    }

    public void incrementQuestion() {
        model.increaseVraagNr();
    }

    public void checkAnswer(int i) {
        boolean correct = model.checkAnswer(i);
        viewController.checkAnswer(correct);

        boolean[] bool = model.colourButtons();
        viewController.colourButton(bool);

        // update player score
        int score = model.getScore();
        viewController.updateScore(score);
    }

    public void setName(String name) {
        model.setPlayerName(name);
    }

    public void makeQuestionArray(){
        model.buildVerzamelingVragen();
        model.fillVragenArray();
    }

    public void buildURL(String maxQuestions) {
        model.setMaxQuestions(maxQuestions);
    }

    public boolean isLastQuestion() {
        return model.isLastQuestion();
    }

    public void getScore() throws Exception {
        viewController.setFinalScreen(model.getScore(), model.getMaxQuestions());
    }

    public void resetGame() {
        // Set score to 0
        model.resetScore();

        // Set Vraagnr to 0
        model.resetVraagnr();
    }

    public void getName() {
        String name = model.getName();
        viewController.returnName(name);
    }
}
