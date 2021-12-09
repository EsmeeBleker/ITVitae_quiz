package Controller;
import Model.*;



public class ModelController {
    private final ViewController viewController;
    Model model = new Model();

    public ModelController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void getQuestion() {
        Vraag vraag1 = model.createQuestion();
        String[] answers = new String[4];
        answers[0] = vraag1.antwoord1.antwoord;
        answers[1] = vraag1.antwoord2.antwoord;
        answers[2] = vraag1.antwoord3.antwoord;
        answers[3] = vraag1.antwoord4.antwoord;
        viewController.setQuestion(vraag1.question);
        //viewController.setAnswerA(vraag1.antwoord1.antwoord);
        //viewController.setAnswerA(vraag1.antwoord2.antwoord);
        //viewController.setAnswerA(vraag1.antwoord3.antwoord);
        //viewController.setAnswerA(vraag1.antwoord4.antwoord);
        viewController.setAnswer(answers);
    }
}
