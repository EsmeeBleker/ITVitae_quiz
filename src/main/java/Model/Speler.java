package Model;
import java.util.ArrayList;

public class Speler
{
    String name;
    private int score;

    public int getScore(){
        return this.score;
    }

    public void increaseScore()
    {
        this.score = this.score + 1;
    }
}
