package Model;

public class Speler
{
    private String name;
    private int score = 0;

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void increaseScore()
    {
        this.score = this.score + 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
