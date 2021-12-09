package Model;

import org.json.JSONObject;


public class VerzamelingVragen {
    private JSONObject vragenObject;

    public VerzamelingVragen(String jsonString) {
        this.vragenObject = new JSONObject(jsonString);

        if (vragenObject.get("response_code").equals(0)){ //Response code: 0 betekent 'correct uitgelezen'
            System.out.println("Vragen van URL correct uitgelezen.");
        }
        else {
            System.out.println("Vragen van URL lezen is fout gegaan. Response code is niet 0");
        }

        //Geeft string met alle vragen: System.out.println(vragenObject.get("results"));

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

    public String getType(int vraagnr) {
        return vragenObject.getJSONArray("results").getJSONObject(vraagnr).get("type").toString();
    }
}
