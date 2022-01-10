package Model;

import java.util.Arrays;
import java.util.Collections;

public class Model {
    //Bij aanmaken van Model wordt een URL aangeroepen en wordt een verzameling vragen in 'verzameling' gestopt.
    //String urlAddress = "https://opentdb.com/api.php?amount=4&type=multiple";         //TODO: url bouwen?
    URLBuilder urlBuilder = new URLBuilder();
    String urlAddress;
    String JSONstring;
    VerzamelingVragen verzameling;
    int verzamelingVragenAantal;
    public Vraag[] VragenArray;
    private int vraagNr;
    private Vraag currentQuestion;
    private String maxQuestions;
    private String categoryQuestions =  "";
    private String categoryNameQuestions = "";
    private String difficultyQuestions ="";

    public void setMaxQuestions(String max){
        this.maxQuestions = max;
    }

    public String getMaxQuestions(){
        return this.maxQuestions;
    }

    public void buildVerzamelingVragen(){
        this.urlBuilder.setAmountQuestions(this.maxQuestions);
        this.urlBuilder.setCategoryNumberQuestions(this.categoryNameQuestions);
        this.urlBuilder.setDifficultyQuestions(this.difficultyQuestions);
        this.urlAddress = urlBuilder.buildURL();
        this.JSONstring = URLReader.read(urlAddress);
        this.verzameling = new VerzamelingVragen(JSONstring);
        this.verzamelingVragenAantal = verzameling.getAmountQuestions();
        this.VragenArray = new Vraag[verzamelingVragenAantal];
    }

    public void fillVragenArray() {
        for (int vraagnr = 0; vraagnr < verzamelingVragenAantal; vraagnr++) {
           Vraag newVraag = createVariableQuestion(vraagnr);
           VragenArray[vraagnr] = newVraag;
        }
    }

    //public Vraag currentQuestion = new Vraag();
    public Speler speler1 = new Speler();

    /*
    public Vraag createQuestion()

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
    }
    */

    public Vraag createVariableQuestion(int vraagnr)
    {
        Vraag vraag1 = new Vraag();
        vraag1.category = verzameling.getCategory(vraagnr);
        vraag1.type = verzameling.getType(vraagnr);
        vraag1.difficulty = verzameling.getType(vraagnr);
        vraag1.question = verzameling.getQuestion(vraagnr);
        vraag1.setVraagnummer(vraagnr);

        Antwoord antwoordA = new Antwoord();
        antwoordA.setAntwoord(verzameling.getCorrectAnswer(vraagnr));
        antwoordA.setCorrect(true);
        Antwoord antwoordB = new Antwoord();
        antwoordB.setAntwoord(verzameling.getIncorrectAnswer(vraagnr,0));
        antwoordB.setCorrect(false);
        Antwoord antwoordC = new Antwoord();
        antwoordC.setAntwoord(verzameling.getIncorrectAnswer(vraagnr,1));
        antwoordC.setCorrect(false);
        Antwoord antwoordD = new Antwoord();
        antwoordD.setAntwoord(verzameling.getIncorrectAnswer(vraagnr,2));
        antwoordD.setCorrect(false);

        Antwoord[] antwoordenLijst = {antwoordA, antwoordB, antwoordC, antwoordD};
        Collections.shuffle(Arrays.asList(antwoordenLijst));

        vraag1.antwoord1 = antwoordenLijst[0].getObject();
        vraag1.antwoord2 = antwoordenLijst[1].getObject();
        vraag1.antwoord3 = antwoordenLijst[2].getObject();
        vraag1.antwoord4 = antwoordenLijst[3].getObject();

        //currentQuestion = vraag1;
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

    public Vraag getQuestionFromVragenArray(int vraagnr) {
        this.currentQuestion = VragenArray[vraagnr];
                return this.VragenArray[vraagnr];
    }

    public int getVraagNr() {
        return this.vraagNr;
    }

    public void increaseVraagNr() {
        this.vraagNr += 1;
    }

    public boolean isLastQuestion() {
        boolean lastQuestion = false;
        if (getVraagNr() == VragenArray.length -1) {
            lastQuestion = true;
        }
        return lastQuestion;
    }

    public void resetScore() {
        speler1.setScore(0);
    }

    public void resetVraagnr() {
        vraagNr = 0;
    }

    public void setCategoryName(String categoryName) {
        this.categoryNameQuestions = categoryName;
    }

    public void setDifficultyName(String difficultyName) {this.difficultyQuestions = difficultyName;}
    }

