package Model;

public class URLBuilder {
    private String baseURL = "https://opentdb.com/api.php?";
    private String amountQuestions = "amount=1";
    private String difficultyQuestions = "";
    private String categoryNumberQuestions = "";
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
            this.difficultyQuestions= "&difficulty=" + difficultyQuestions;
        }
    }

    public String buildURL() {
        String URL = baseURL + amountQuestions + categoryNumberQuestions + difficultyQuestions + typeQuestions;
        System.out.println(URL);
        return URL;
    }

    public void setCategoryNumberQuestions(String categoryNameQuestions) {
        this.categoryNumberQuestions = getCategoryNumberFromName(categoryNameQuestions);
        if (categoryNumberQuestions.equals("") || categoryNumberQuestions.equals(Integer.toString(Categorieën.categoryStartingNumber))) {
            this.categoryNumberQuestions = "";
        } else {
            this.categoryNumberQuestions = "&category=" + categoryNumberQuestions;
        }
    }

    private String getCategoryNumberFromName(String categoryNameQuestions) {
        String categoryNumber = "";
        for (int entry = 0; entry < Categorieën.getAllCategoryNames().length; entry++)
            if (Categorieën.getAllCategoryNames()[entry].equals(categoryNameQuestions)) {
                categoryNumber = Integer.toString(entry + Categorieën.categoryStartingNumber);
            }
        return categoryNumber;
    }

}
