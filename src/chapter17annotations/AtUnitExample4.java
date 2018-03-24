package chapter17annotations;

import unittest.*;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 24.08.17.
 */
public class AtUnitExample4 {
    static String theory = "All brontosauruses are thin at one end, much MUCH thicker in the middle, and then thin again at the far end.";
    private String word;
    private Random rand = new Random(47);
    public AtUnitExample4(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }
    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for(char ch : word.toCharArray())
            chars.add(ch);
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for(char ch : chars)
            result.append(ch);
        return result.toString();
    }

    @TestProperty static List<String> input = Arrays.asList(theory.split(" "));
    @TestProperty static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if(words.hasNext())
            return new AtUnitExample4(words.next());
        else
            return null;
    }

    @Test boolean words() {
        print("'" + getWord() + "'");
        return getWord().equals("are");
    }
    @Test boolean scramble1() {
        // Change to a specific seed to get verifiable results"
        rand = new Random(47);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("lAl");
    }
    @Test boolean scramble2() {
        rand = new Random(74);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("tsaeborornussu");
    }
    public static void main(String... args) {
        AtUnit.runTest("chapter17annotations/AtUnitExample4");
    }
}
