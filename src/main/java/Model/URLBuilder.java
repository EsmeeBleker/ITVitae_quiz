package Model;

public class URLBuilder {
    private String baseURL = "https://opentdb.com/api.php?";
    private String amountQuestions = "amount=1";
    private String difficultyQuestions = "";
    private String typeQuestions = "&type=multiple";

    public static void main(String[] args) {
    }

    public void setAmountQuestions(String amountQuestions) {
        this.amountQuestions = "amount=" + amountQuestions;
    }

    public void setDifficultyQuestions(String difficultyQuestions) {
        this.amountQuestions = "&difficulty=" + difficultyQuestions;
    }

    public String buildURL() {
        String URL = baseURL + amountQuestions + difficultyQuestions + typeQuestions;
        return URL;
    }
}
