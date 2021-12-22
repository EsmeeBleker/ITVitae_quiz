package Model;

public class Categorieën {
    public static int categoryStartingNumber = 8;

    static String[][] categories =
            {{"", "(no category, all sorts of questions!)"},
            {"9", "General Knowledge"},
            {"10", "Entertainment: Books"},
            {"11", "Entertainment: Film"},
            {"12", "Entertainment: Music"},
            {"13", "Entertainment: Musicals & Theatres"},
            {"14", "Entertainment: Television"},
            {"15", "Entertainment: Video Games"},
            {"16", "Entertainment: Board Games"},
            {"17", "Science & Nature"},
            {"18", "Science: Computers"},
            {"19", "Science: Mathematics"},
            {"20", "Mythology"},
            {"21", "Sports"},
            {"22", "Geography"},
            {"23", "History"},
            {"24", "Politics"},
            {"25", "Art"},
            {"26", "Celebrities"},
            {"27", "Animals"},
            {"28", "Vehicles"},
            {"29", "Entertainment: Comics"},
            {"30", "Science: Gadgets"},
            {"31", "Entertainment: Japanese Anime & Manga"},
            {"32", "Entertainment: Cartoon & Animations"}};

    public String getCategoryName(int categoryNumber) {
        int numberInArray = categoryNumber - Categorieën.categoryStartingNumber;
        return this.categories[numberInArray][1];
    }

    public static String[][] getAllCategories() {
        return categories;
    }

    public static String[] getAllCategoryNames() {
        String[] stringArray = new String[getAllCategories().length];
        for (int i=0; i < getAllCategories().length; i++) {
            stringArray[i] = getAllCategories()[i][1];
        }
        return stringArray;
    }

}