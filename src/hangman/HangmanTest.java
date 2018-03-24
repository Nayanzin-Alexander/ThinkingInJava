package hangman;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by nayanzin on 26.08.17.
 */
public class HangmanTest {

    Hangman game = new Hangman("sofa");

    @Test
    public void youSeeMaskedWord() {
        assertEquals("____", game.getWord());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void youMustGuessLetters() {
        game.guessLetter('o');
        assertEquals("_o__", game.getWord());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void youHave6Guesses() {
        game.guessLetter('x');
        assertEquals(1, game.getFailuresCount());
        game.guessLetter('y');
        game.guessLetter('z');
        game.guessLetter('u');
        game.guessLetter('t');
        assertFalse(game.isLost());
        game.guessLetter('i');
        assertTrue(game.isLost());
        assertEquals(6, game.getFailuresCount());
    }

    @Test
    public void gameIsNotLostInTheBegining() {
        assertFalse(game.isLost());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void youWinWhenYouGuessedAllLetters() {
        game.guessLetter('s');
        game.guessLetter('o');
        game.guessLetter('f');
        assertFalse(game.isWon());
        game.guessLetter('a');
        assertTrue(game.isWon());
        assertEquals(0, game.getFailuresCount());
    }

    @Test
    public void multiplyClicks() {
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        game.guessLetter('q');
        assertEquals(1, game.getFailuresCount());
        assertFalse(game.isWon());
        assertFalse(game.isLost());

    }
}
