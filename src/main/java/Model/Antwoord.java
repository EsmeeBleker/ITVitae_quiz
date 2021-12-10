package Model;

public class Antwoord {
    private String antwoord;
    private boolean correct;

    public boolean getCorrect(){
        return this.correct;
    }
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }
    public String getAntwoord() {
        return this.antwoord;
    }

    public Antwoord getObject() {
        return this;
    }
}
