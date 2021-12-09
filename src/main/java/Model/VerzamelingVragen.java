package Model;

import org.json.JSONObject;


public class VerzamelingVragen {
    private JSONObject vragenObject;

    public VerzamelingVragen(String jsonString) throws Exception {
        this.vragenObject = new JSONObject(jsonString);

        if (vragenObject.get("response_code").equals(0)){
            System.out.println("Vragen van URL gelezen. Response code is 0 (Correct)");
        }
        else {
            throw new Exception("Vragen van URL lezen is fout gegaan. Response code is niet 0");
        }
        System.out.println("Code: " + vragenObject.get("response_code"));

        System.out.println(vragenObject.get("results"));

    }

    public String getQuestion(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("question").toString();
    }

    public String getCorrectAnswer(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("correct_answer").toString();
    }

    public int getAmountQuestions() {
        return vragenObject.getJSONArray("results").length();
    }

    public String getIncorrectAnswers(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("incorrect_answers").toString();
    }

    public int getAmountIncorrectAnswers(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).getJSONArray("incorrect_answers").length();
    }

    public String getCategory(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("category").toString();
    }

    public String getIncorrectAnswer(int vraagnr, int antwoordnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).getJSONArray("incorrect_answers").get(antwoordnr).toString();
    }

    public String getDifficulty(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("difficulty").toString();
    }
}
