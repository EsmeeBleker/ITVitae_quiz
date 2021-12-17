package Model;

import org.apache.commons.lang3.StringEscapeUtils;

public class GekkeTekensWeg { //&quot  ->  "

    public static String HTMLnaarLeesbaar(String escapedString){
        String unEscapedHTML = StringEscapeUtils.unescapeHtml4(escapedString);
        return(unEscapedHTML);
    }

}
