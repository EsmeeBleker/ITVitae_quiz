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
    private int vraagnummer;

    public int getVraagnummer(){
        return this.vraagnummer;
    }

    public void setVraagnummer(int index){
        this.vraagnummer = index;
    }
}
