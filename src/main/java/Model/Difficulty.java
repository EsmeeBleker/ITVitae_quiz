package Model;

public class Difficulty {
    static String[] difficulties =
            {"Easy","Medium","Hard" };
    public static String difficulty = "";


    public String getDifficultyName(String difficulty) {
        return difficulty;

    }

    public static String[] getAllDifficulties() {
        return difficulties;
    }

}
