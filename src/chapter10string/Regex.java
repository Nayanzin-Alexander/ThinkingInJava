package chapter10string;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.07.17.
 */
public class Regex {
    public static void main(String... args) {
        String input = "<a id = 'id55' href = \"http://google.com\">";
        String regex;
        //regex = "href[\\s]*=([\\s]*\"([^\"]*)\"|'([^']*)'|([^>\\s]*))"; //href src
        //regex = "<[//s]*([A-Za-z]+)";  //tagName
        regex = "id[\\s]*=[\\s]*(?>\"([^\"]*)\"|'([^']*)'|([^>\\s]+))[\\s]{1}";

        //regex = "id[\\s]*=[\\s]*=";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            for(int i=0; i< matcher.groupCount()+1; i++){
                //if(matcher.group(i) != null)
                    print("Group " + i + "  " + matcher.group(i));
            }
            found = true;
        }
        if (!found) {
            print(String.format("No match found.%n"));
        }
    }
}

