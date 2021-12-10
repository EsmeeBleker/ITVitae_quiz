package Model;




public class Model {
    //Bij aanmaken van Model wordt een URL aangeroepen en wordt een verzameling vragen in 'verzameling' gestopt.
    String urlAddress = "https://opentdb.com/api.php?amount=1&type=multiple";         //TODO: url bouwen?
    URLReader reader = new URLReader();
    String JSONstring = reader.read(urlAddress);
    VerzamelingVragen verzameling = new VerzamelingVragen(JSONstring);

    public Vraag currentQuestion = new Vraag();
    public Speler speler1 = new Speler();

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

    public Vraag createVariableQuestion()
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = verzameling.getCategory(0);
        vraag1.type = verzameling.getType(0);
        vraag1.difficulty = verzameling.getType(0);
        vraag1.question = verzameling.getQuestion(0);
        Antwoord antwoord1 = new Antwoord();
        antwoord1.antwoord = verzameling.getCorrectAnswer(0);
        antwoord1.correct = true;
        Antwoord antwoord2 = new Antwoord();
        antwoord2.antwoord = verzameling.getIncorrectAnswer(0,0);
        antwoord2.correct = false;
        Antwoord antwoord3 = new Antwoord();
        antwoord3.antwoord = verzameling.getIncorrectAnswer(0,1);
        antwoord3.correct = false;
        Antwoord antwoord4 = new Antwoord();
        antwoord4.antwoord = verzameling.getIncorrectAnswer(0,2);
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
            if (currentQuestion.antwoord1.correct == true)
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord1.correct;
        }
        else if (i == 2)
        {
            if (currentQuestion.antwoord2.correct == true)
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord2.correct;
        }
        else if (i == 3)
        {
            if (currentQuestion.antwoord3.correct == true)
            {
                speler1.increaseScore();
            }
            return currentQuestion.antwoord3.correct;
        }
        else
        {
            if (currentQuestion.antwoord4.correct == true)
            {
                speler1.increaseScore();
            }
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

    public int getScore()
    {
        return speler1.getScore();
    }
}
