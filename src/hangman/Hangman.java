package hangman;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nayanzin on 26.08.17.
 */
public class Hangman {
    private final String word;
    private String maskedWord;
    int failures;
    private Set<Character> usedChars = new HashSet<>();

    public Hangman(String word) {
        this.word = word;
        this.maskedWord = word.replaceAll(".", "_");
    }

    public String getWord() {
        return maskedWord;
    }

    public void guessLetter(char letter) {
        int index = word.indexOf(letter);
        if(index < 0) {
            if(!usedChars.contains(letter)) {
                usedChars.add(letter);
                failures++;
            }
            return;
        }
        maskedWord = maskedWord.substring(0, index) + letter + maskedWord.substring(index + 1);
    }

    public boolean isLost() {
        return failures > 5;
    }

    public boolean isWon() {
        return !maskedWord.contains("_");
    }

    public int getFailuresCount() {
        return failures;
    }
}
