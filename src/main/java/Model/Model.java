package Model;

public class Model {
    public Vraag createQuestion()
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = "Entertainment: Video Games";
        vraag1.type = "medium";
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
        return (vraag1);
    }


}
