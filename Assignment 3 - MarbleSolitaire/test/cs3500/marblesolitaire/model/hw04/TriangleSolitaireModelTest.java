// Aaryan Jain and Zindagi Kamra
package cs3500.marblesolitaire.model.hw04;

import static org.junit.Assert.*;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;
import org.junit.Test;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState.SlotState;

/**
 * Tests if EnglishSolitaireModel's methods work and if it created with a valid state
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class TriangleSolitaireModelTest {

  MarbleSolitaireModel boardThree = new TriangleSolitaireModel();
  MarbleSolitaireModel boardFive = new TriangleSolitaireModel(5);
  MarbleSolitaireModel boardFourFour = new TriangleSolitaireModel(4, 4);
  MarbleSolitaireModel boardNine = new TriangleSolitaireModel(9, 3, 2);

  @Test
  public void testThreeArgumentConstructor() {
    // boardSeven is an example of a 3 argument constructor, for it,
    // the constructor should create a board of size 19, score of 216
    // with an empty slot at (10,6) and a marble at every valid slot it is given on the board with
    // off board slots on the board showing a SlotState.Invalid. We can check this using methods
    // from the MarbleSolitaireModel interface
    assertEquals(9, boardNine.getBoardSize());
    assertEquals(44, boardNine.getScore());
    assertEquals(SlotState.Marble, boardNine.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, boardNine.getSlotAt(0, 6));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(7, 3));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(8, 0));

    // Error test here
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(8, 10, 6);
      fail("No exception thrown for invalid thickness");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(8, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(1, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(-1, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(7, -4, 2);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(7, 8, 5);
      fail("No exception thrown for invalid sRow and sCol, even if present within grid as not on " +
          "game board");
    } catch (Exception e) {
      // works as expected
    }

    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(5, 4, 14);
      fail("No exception thrown for invalid sCol");
    } catch (Exception e) {
      // works as expected
    }

  }

  @Test
  public void testOneArgumentConstructor() {
    // boardFive is an example of a 1 argument constructor
    // it should create a board of size 13, score of 104
    // with an empty slot at (6,6) and a marble at every valid slot it is given on the board with
    // off board slots on the board showing a SlotState.Invalid. We can check this using methods
    // from the MarbleSolitaireModel interface
    assertEquals(5, boardFive.getBoardSize());
    assertEquals(14, boardFive.getScore());
    assertEquals(SlotState.Empty, boardFive.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(3, 4));

    // Error test here
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(10);
      fail("No exception thrown for odd dimension");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(1);
      fail("No exception thrown for invalid dimension");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(-1);
      fail("No exception thrown for negative dimension");
    } catch (Exception e) {
      // works as expected
    }
  }

  @Test
  public void testTwoArgumentConstructor() {
    // boardFourFour is an example of a 2 argument constructor
    // it should create a board of size 7, score of 32
    // with an empty slot at (4,4) and a marble at every valid slot it is given on the board with
    // off board slots on the board showing a SlotState.Invalid. We can check this using methods
    // from the MarbleSolitaireModel interface
    assertEquals(5, boardFourFour.getBoardSize());
    assertEquals(14, boardFourFour.getScore());
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 0));

    // Error test here
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(-2, 3);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(2, -4);
      fail("No exception thrown for invalid sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(8, 3);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(2, 9);
      fail("No exception thrown for invalid sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(5, 6);
      fail("No exception thrown for invalid sRow and sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      TriangleSolitaireModel boardSeven = new TriangleSolitaireModel(-3, 0);
      fail("No exception thrown for invalid sRow and sCol");
    } catch (Exception e) {
      // works as expected
    }


  }

  @Test
  public void testNoArgumentConstructor() {
    // boardThree is an example of a no argument constructor
    // it should create a board of size 7, score of 32
    // with an empty slot at (3,3) and a marble at every valid slot it is given on the board with
    // off board slots on the board showing a SlotState.Invalid. We can check this using methods
    // from the MarbleSolitaireModel interface
    assertEquals(5, boardThree.getBoardSize());
    assertEquals(14, boardThree.getScore());
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, boardThree.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(1, 4));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(4, 0));

  }


  @Test
  public void testMove() {
    // Testing a move on an TriangleSolitaireModel created using the default constructor
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 1));
    assertEquals(14, boardThree.getScore());
    boardThree.move(2, 0, 0, 0);
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 1));
    assertEquals(13, boardThree.getScore());

    // Testing a move on an TriangleSolitaireModel created using the constructor taking in one
    // argument
    assertEquals(SlotState.Marble, boardFive.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(3, 4));
    assertEquals(14, boardFive.getScore());
    boardFive.move(2, 0, 0, 0);
    assertEquals(SlotState.Marble, boardFive.getSlotAt(3, 2));
    assertEquals(13, boardFive.getScore());

    // Testing a move on an TriangleSolitaireModel created using the constructor taking in two
    // arguments
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(3, 4));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(2, 4));
    assertEquals(14, boardFourFour.getScore());
    boardFourFour.move(4, 2, 4, 4);
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(2, 2));
    assertEquals(13, boardFourFour.getScore());

    // Testing a move on an TriangleSolitaireModel created using the constructor taking in three
    // arguments
    assertEquals(SlotState.Marble, boardNine.getSlotAt(8, 6));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(7, 6));
    assertEquals(44, boardNine.getScore());
    boardNine.move(1, 0, 3, 2);
    assertEquals(SlotState.Invalid, boardNine.getSlotAt(5, 6));
    assertEquals(SlotState.Invalid, boardNine.getSlotAt(2, 6));
    assertEquals(43, boardNine.getScore());

    //Error tests
    try {
      boardThree.move(-2, 3, 4, 5);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(7, 3, 4, 5);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(2, -8, 4, 5);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(2, 8, 4, 5);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(2, 2, -4, 5);

      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {

      boardThree.move(2, 2, 14, 5);

      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(2, 2, 4, -16);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
    try {
      boardThree.move(2, 2, 4, 8);
      fail("Did not throw Illegal Argument Exception for out of bound indexes");
    } catch (Exception e) {
      // works
    }
  }

  @Test
  public void testIsGameOver() {
    assertEquals(false, boardThree.isGameOver());
    boardThree.move(2, 0, 0, 0);
    boardThree.move(2, 2, 2, 0);
    boardThree.move(3, 0, 1, 0);
    boardThree.move(3, 2, 3, 0);
    boardThree.move(4, 0, 2, 0);
    boardThree.move(1, 0, 3, 0);
    boardThree.move(4, 2, 4, 0);
    boardThree.move(4, 0, 2, 0);
    boardThree.move(4, 4, 4, 2);
    boardThree.move(0, 0, 2, 2);
    boardThree.move(2, 2, 4, 4);
    assertEquals(true, boardThree.isGameOver());
    assertEquals(false, boardFive.isGameOver());
    assertEquals(false, boardNine.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(5, boardThree.getBoardSize());
    assertEquals(5, boardFive.getBoardSize());
    assertEquals(5, boardFourFour.getBoardSize());
    assertEquals(44, boardNine.getScore());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Empty, boardThree.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(3, 4));

    assertEquals(SlotState.Empty, boardFive.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(2, 2));

    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(4, 3));
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));

    assertEquals(SlotState.Marble, boardNine.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(7, 6));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(8, 8));
    assertEquals(SlotState.Marble, boardNine.getSlotAt(6, 2));

    // Error tests
    try {
      boardThree.getSlotAt(-4, 2);
      fail("No exception thrown for invalid row");
    } catch (Exception e) {
      //works
    }
    try {
      boardThree.getSlotAt(8, 2);
      fail("No exception thrown for invalid row");
    } catch (Exception e) {
      //works
    }
    try {
      boardThree.getSlotAt(3, -800);
      fail("No exception thrown for invalid column");
    } catch (Exception e) {
      //works
    }
    try {
      boardThree.getSlotAt(3, 17);
      fail("No exception thrown for invalid column");
    } catch (Exception e) {
      //works
    }

  }

  @Test
  public void testGetScore() {
    assertEquals(14, boardThree.getScore());
    boardThree.move(2, 0, 0, 0);
    assertEquals(13, boardThree.getScore());
    boardThree.move(3, 2, 1, 0);
    assertEquals(12, boardThree.getScore());

    assertEquals(14, boardFourFour.getScore());
    boardFourFour.move(4, 2, 4, 4);
    assertEquals(13, boardFourFour.getScore());
    boardFourFour.move(4, 0, 4, 2);
    assertEquals(12, boardFourFour.getScore());

    assertEquals(44, boardNine.getScore());
    boardNine.move(1, 0, 3, 2);
    assertEquals(43, boardNine.getScore());
    boardNine.move(3, 0, 1, 0);
    assertEquals(42, boardNine.getScore());
  }


}