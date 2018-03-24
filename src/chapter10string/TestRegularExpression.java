package chapter10string;

import java.util.regex.*;
import static myutil.Printer.*;

/**
 * Created by nayanzin on 06.07.17.
 */
public class TestRegularExpression {
    public static void main(String... args){
        String patternString = ".";
        String[] regexs = new String[]{
                "^Java",
                "\\Breg.*",
                "n.w\\s+h(a|i)s",
                "s?",
                "s*",
                "s+",
                "s{4}",
                "S{1}.",
                "s{0,3}"};

        String searchString = "Java now has regular expressions";

        for(String regex : regexs){
            Pattern myPattern = Pattern.compile(regex);
            Matcher myMatcher = myPattern.matcher(searchString);
            int count = 0;
            print("Trying regex " + regex);
            while(myMatcher.find()){
                count++;
                print("    Found " + myMatcher.group());
            }
            print(" Found " + count + " matches.");
        }
    }
}
