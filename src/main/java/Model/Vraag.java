package Model;


public class Vraag
{
    public String category;
    public String type;
    public String difficulty;
    public String question;
    public Antwoord antwoord1;
    public Antwoord antwoord2;
    public Antwoord antwoord3;
    public Antwoord antwoord4;
    private int vraagnr;

    public int getVraagnummer(){
        return this.vraagnr;
    }

    public void setVraagnummer(int index){
        this.vraagnr = index;
    }
}
