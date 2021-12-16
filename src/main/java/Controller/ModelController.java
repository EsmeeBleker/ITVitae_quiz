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

    public void fillArray(){
        model.fillVragenArray();
    }

    public boolean isLastQuestion() {
        return model.isLastQuestion();
    }
}
