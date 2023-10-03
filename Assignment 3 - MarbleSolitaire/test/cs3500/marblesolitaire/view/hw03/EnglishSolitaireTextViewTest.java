//Aaryan Jain and Zindagi Kamra
package cs3500.marblesolitaire.view.hw03;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw03.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;

import static org.junit.Assert.*;

/**
 * Tests MarbleSolitaireModel methods and if the object is valid
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class EnglishSolitaireTextViewTest {
  MarbleSolitaireModel game = new EnglishSolitaireModel();
  MarbleSolitaireView board = new EnglishSolitaireTextView(game);


  @Test
  public void testInvalidConstructor() {
    try {
      MarbleSolitaireView board2 = new EnglishSolitaireTextView(null);
      fail("Did not throw IllegalArgumentException for null parameter");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireView board2 = new EnglishSolitaireTextView(null, System.out);
      fail("Didn't throw error for null board");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireView board2 = new EnglishSolitaireTextView(game, null);
      fail("Didn't throw error for null appendable");
    } catch (Exception e) {
      // works
    }
    try {
      MarbleSolitaireView board2 = new EnglishSolitaireTextView(null, null);
      fail("Didn't throw error for null board or null appendable");
    } catch (Exception e) {
      // works
    }
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.toString());
    game.move(3, 1, 3, 3);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.toString());
    game.move(1, 2, 3, 2);
    assertEquals("    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O _ O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.toString());
    game.move(3, 3, 3, 1);
    assertEquals("    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O O _ _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.toString());
  }

  @Test
  public void testRenderBoard() {
    try {
      board.renderBoard();
    } catch (Exception e) {
      fail("No error should be thrown for correct transmission");
    }
  }

  @Test
  public void testRenderMessage() {
    try {
      board.renderMessage("\nMessage\n");
    } catch (Exception e) {
      fail("No error should be thrown for correct transmission");
    }
  }
}