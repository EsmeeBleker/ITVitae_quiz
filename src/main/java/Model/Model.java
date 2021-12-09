package Model;

public class Model {
    public Vraag currentQuestion = new Vraag();

    public Vraag createQuestion()
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = "Entertainment: Video Games";
        vraag1.type = "multiple";
        vraag1.difficulty = "medium";
        vraag1.question = "In Kingdom Hearts, who abducts Jasmine in the Lamp Chamber?";
        Antwoord antwoord1 = new Antwoord();
        antwoord1.antwoord ="Riku";
        antwoord1.correct = true;
        Antwoord antwoord2 = new Antwoord();
        antwoord2.antwoord ="Riku Replica";
        antwoord2.correct = false;
        Antwoord antwoord3 = new Antwoord();
        antwoord3.antwoord ="Xaldin";
        antwoord3.correct = false;
        Antwoord antwoord4 = new Antwoord();
        antwoord4.antwoord ="Captain Hook";
        antwoord4.correct = false;
        vraag1.antwoord1 = antwoord1;
        vraag1.antwoord2 = antwoord2;
        vraag1.antwoord3 = antwoord3;
        vraag1.antwoord4 = antwoord4;
        currentQuestion = vraag1;
        return (vraag1);
    }


    public boolean checkAnswer(int i)
    {
        if (i == 1)
        {
            return currentQuestion.antwoord1.correct;
        }
        else if (i == 2)
        {
            return currentQuestion.antwoord2.correct;
        }
        else if (i == 3)
        {
            return currentQuestion.antwoord3.correct;
        }
        else
        {
            return currentQuestion.antwoord4.correct;
        }
    }

    public boolean[] colourButtons()
    {
        boolean a = currentQuestion.antwoord1.correct;
        boolean b = currentQuestion.antwoord2.correct;
        boolean c = currentQuestion.antwoord3.correct;
        boolean d = currentQuestion.antwoord4.correct;
        boolean[] bool = new boolean[] {a, b, c, d};
        return bool;
    }
}
