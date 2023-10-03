package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.view.hw03.EnglishSolitaireTextView;
import java.io.InputStreamReader;
import org.junit.Test;
import cs3500.marblesolitaire.model.hw03.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireView;
import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Tests constructor validity and error throws for MarbleSolitaireController
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class MarbleSolitaireControllerImplTest {
  MarbleSolitaireModel game = new EnglishSolitaireModel(3);
  MarbleSolitaireView board = new EnglishSolitaireTextView(game);

  @Test
  public void testValidConstructor() {
    try {
      MarbleSolitaireController controller =
          new MarbleSolitaireControllerImpl(game, board, new InputStreamReader(System.in));
    } catch (Exception e) {
      fail("Should have ran properly since valid constructor");
    }
  }

  @Test
  public void testInvalidConstructors1() {
    try {
      MarbleSolitaireController controller1 =
          new MarbleSolitaireControllerImpl(null,
              board, new InputStreamReader(System.in));
      fail("Should have failed since invalid MarbleSolitaireModel");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireController controller1 =
          new MarbleSolitaireControllerImpl(game,
              null, new InputStreamReader(System.in));
      fail("Should have failed since invalid MarbleSolitaireView");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireController controller1 =
          new MarbleSolitaireControllerImpl(game,
              board, null);
      fail("Should have failed since invalid Readable");
    } catch (Exception e) {
      // works
    }
  }

  @Test
  public void testValidMessage() {
    Readable readable = new StringReader("q");
    Appendable appendable = new StringBuilder();

    MarbleSolitaireView testView = new EnglishSolitaireTextView(game, appendable);
    MarbleSolitaireController controller =
        new MarbleSolitaireControllerImpl(game, testView, readable);
    controller.playGame();

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "From Row: \n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32", appendable.toString());

  }

  @Test
  public void testValidMove() {
    Readable readable = new StringReader("2\n4\n4\n4\nq");
    Appendable appendable = new StringBuilder();

    MarbleSolitaireView testView = new EnglishSolitaireTextView(game, appendable);
    MarbleSolitaireController controller =
        new MarbleSolitaireControllerImpl(game, testView, readable);
    controller.playGame();


    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "From Row: \n" +
        "From Col: \n" +
        "To Row: \n" +
        "To Col: \n" +
        "    O O O\n" +
        "    O _ O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "From Row: \n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O _ O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31", appendable.toString());
  }

  @Test
  public void testInvalidMove() {
    Readable readable = new StringReader("3\n4\n4\n4\nq");
    Appendable appendable = new StringBuilder();

    MarbleSolitaireView testView = new EnglishSolitaireTextView(game, appendable);
    MarbleSolitaireController controller =
        new MarbleSolitaireControllerImpl(game, testView, readable);
    controller.playGame();

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "From Row: \n" +
        "From Col: \n" +
        "To Row: \n" +
        "To Col: \n" +
        "Invalid indexes given for move, please re-enter values:\n" +
        "From Row: \n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32", appendable.toString());
  }

}