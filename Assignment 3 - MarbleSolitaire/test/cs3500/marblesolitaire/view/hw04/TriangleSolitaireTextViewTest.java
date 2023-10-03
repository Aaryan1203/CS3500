//Aaryan Jain and Zindagi Kamra
package cs3500.marblesolitaire.view.hw04;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireView;
import org.junit.Test;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;

import static org.junit.Assert.*;

/**
 * Tests TriangleSolitaireTextView methods and if the object is valid
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class TriangleSolitaireTextViewTest {
  MarbleSolitaireModel game = new TriangleSolitaireModel();
  MarbleSolitaireView board = new TriangleSolitaireTextView(game);


  @Test
  public void testInvalidConstructor() {
    try {
      MarbleSolitaireView board2 = new TriangleSolitaireTextView(null);
      fail("Did not throw IllegalArgumentException for null parameter");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireView board2 = new TriangleSolitaireTextView(null, System.out);
      fail("Didn't throw error for null board");
    } catch (Exception e) {
      // works
    }

    try {
      MarbleSolitaireView board2 = new TriangleSolitaireTextView(game, null);
      fail("Didn't throw error for null appendable");
    } catch (Exception e) {
      // works
    }
    try {
      MarbleSolitaireView board2 = new TriangleSolitaireTextView(null, null);
      fail("Didn't throw error for null board or null appendable");
    } catch (Exception e) {
      // works
    }
  }

  @Test
  public void testToString() {
    assertEquals("    _\n"
        + "   0 0\n"
        + "  0 0 0\n"
        + " 0 0 0 0\n"
        + "0 0 0 0 0", board.toString());
    game.move(2, 0, 0, 0);
    assertEquals("    0\n"
        + "   _ 0\n"
        + "  _ 0 0\n"
        + " 0 0 0 0\n"
        + "0 0 0 0 0", board.toString());
    game.move(2, 2, 2, 0);
    assertEquals("    0\n"
        + "   _ 0\n"
        + "  0 _ _\n"
        + " 0 0 0 0\n"
        + "0 0 0 0 0", board.toString());
    game.move(4, 4, 2, 2);
    assertEquals("    0\n"
        + "   _ 0\n"
        + "  0 _ 0\n"
        + " 0 0 0 _\n"
        + "0 0 0 0 _", board.toString());
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