package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

//Gebaseerd op https://stackoverflow.com/questions/53520796/read-url-in-java
public class URLReader {
    public static void main(String[] args) {
    }

    public static String read(String urlAddress) {
        BufferedReader br;
        String jsonString = null;
        try {
            URL url = new URL(urlAddress);
            url.openConnection();
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }
            jsonString = sb.toString();

        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
        return jsonString;
    }
}
