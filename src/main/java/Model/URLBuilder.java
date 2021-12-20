package Model;

public class URLBuilder {
    private String baseURL = "https://opentdb.com/api.php?";
    private String amountQuestions = "amount=1";
    private String difficultyQuestions = "";
    private String categoryQuestions = "";
    private String typeQuestions = "&type=multiple";

    public static void main(String[] args) {
    }

    public void setAmountQuestions(String amountQuestions) {
        this.amountQuestions = "amount=" + amountQuestions;
    }

    public void setDifficultyQuestions(String difficultyQuestions) {
        if (difficultyQuestions.equals("")) {
            //do nothing
        } else {
            this.amountQuestions = "&difficulty=" + difficultyQuestions;
        }
    }

    public String buildURL() {
        String URL = baseURL + amountQuestions + categoryQuestions + difficultyQuestions + typeQuestions;
        return URL;
    }

    public void setCategoryQuestions(String categoryQuestions) {
        //categoryQuestions between 9 and 32. If outside those numbers (in string format) the URL will not return questions
        if (categoryQuestions.equals("")) {
            //do nothing
        } else {
            this.categoryQuestions = "&category=" + categoryQuestions;
        }
    }
}
