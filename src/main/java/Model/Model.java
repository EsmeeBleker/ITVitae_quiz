package Model;


import java.util.Arrays;
import java.util.Collections;

public class Model {
    //Bij aanmaken van Model wordt een URL aangeroepen en wordt een verzameling vragen in 'verzameling' gestopt.
    String urlAddress = "https://opentdb.com/api.php?amount=1&type=multiple";         //TODO: url bouwen?
    String JSONstring = URLReader.read(urlAddress);
    VerzamelingVragen verzameling = new VerzamelingVragen(JSONstring);

    public Vraag currentQuestion = new Vraag();
    public Speler speler1 = new Speler();

    /*public Vraag createQuestion()
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = "Entertainment: Video Games";
        vraag1.type = "multiple";
        vraag1.difficulty = "medium";
        vraag1.question = "In Kingdom Hearts, who abducts Jasmine in the Lamp Chamber?";

        Antwoord antwoordA = new Antwoord();
        antwoordA.setAntwoord("Riku");
        antwoordA.setCorrect(true);
        Antwoord antwoordB = new Antwoord();
        antwoordB.setAntwoord("Riku Replica");
        antwoordB.setCorrect(false);
        Antwoord antwoordC = new Antwoord();
        antwoordC.setAntwoord("Xaldin");
        antwoordC.setCorrect(false);
        Antwoord antwoordD = new Antwoord();
        antwoordD.setAntwoord("Captain Hook");
        antwoordD.setCorrect(false);

        Antwoord[] antwoordenLijst = {antwoordA, antwoordB, antwoordC, antwoordD};
        Collections.shuffle(Arrays.asList(antwoordenLijst));

        vraag1.antwoord1 = antwoordenLijst[0].getObject();
        vraag1.antwoord2 = antwoordenLijst[1].getObject();
        vraag1.antwoord3 = antwoordenLijst[2].getObject();
        vraag1.antwoord4 = antwoordenLijst[3].getObject();


        currentQuestion = vraag1;
        return (vraag1);
    }*/

    public Vraag createVariableQuestion()
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = verzameling.getCategory(0);
        vraag1.type = verzameling.getType(0);
        vraag1.difficulty = verzameling.getType(0);
        vraag1.question = verzameling.getQuestion(0);

        Antwoord antwoordA = new Antwoord();
        antwoordA.setAntwoord(verzameling.getCorrectAnswer(0));
        antwoordA.setCorrect(true);
        Antwoord antwoordB = new Antwoord();
        antwoordB.setAntwoord(verzameling.getIncorrectAnswer(0,0));
        antwoordB.setCorrect(false);
        Antwoord antwoordC = new Antwoord();
        antwoordC.setAntwoord(verzameling.getIncorrectAnswer(0,1));
        antwoordC.setCorrect(false);
        Antwoord antwoordD = new Antwoord();
        antwoordD.setAntwoord(verzameling.getIncorrectAnswer(0,2));
        antwoordD.setCorrect(false);

        Antwoord[] antwoordenLijst = {antwoordA, antwoordB, antwoordC, antwoordD};
        Collections.shuffle(Arrays.asList(antwoordenLijst));

        vraag1.antwoord1 = antwoordenLijst[0].getObject();
        vraag1.antwoord2 = antwoordenLijst[1].getObject();
        vraag1.antwoord3 = antwoordenLijst[2].getObject();
        vraag1.antwoord4 = antwoordenLijst[3].getObject();

        currentQuestion = vraag1;
        return (vraag1);
    }


    public boolean checkAnswer(int i)
    {
        if (i == 1)
        {
            if (currentQuestion.antwoord1.getCorrect())
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord1.getCorrect();
        }
        else if (i == 2)
        {
            if (currentQuestion.antwoord2.getCorrect())
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord2.getCorrect();
        }
        else if (i == 3)
        {
            if (currentQuestion.antwoord3.getCorrect())
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord3.getCorrect();
        }
        else
        {
            if (currentQuestion.antwoord4.getCorrect())
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord4.getCorrect();
        }
    }

    public boolean[] colourButtons()
    {
        boolean a = currentQuestion.antwoord1.getCorrect();
        boolean b = currentQuestion.antwoord2.getCorrect();
        boolean c = currentQuestion.antwoord3.getCorrect();
        boolean d = currentQuestion.antwoord4.getCorrect();
        return new boolean[] {a, b, c, d};
    }

    public int getScore()
    {
        return speler1.getScore();
    }

    public void setPlayerName(String name) {
        speler1.setName(name);
    }
}
