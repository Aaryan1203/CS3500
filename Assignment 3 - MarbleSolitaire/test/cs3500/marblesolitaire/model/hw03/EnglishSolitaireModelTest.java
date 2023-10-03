// Aaryan Jain and Zindagi Kamra
package cs3500.marblesolitaire.model.hw03;

import static org.junit.Assert.*;

import org.junit.Test;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState.SlotState;

/**
 * Tests if EnglishSolitaireModel's methods work and if it created with a valid state
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class EnglishSolitaireModelTest {

  MarbleSolitaireModel boardThree = new EnglishSolitaireModel();
  MarbleSolitaireModel boardFive = new EnglishSolitaireModel(5);
  MarbleSolitaireModel boardFourFour = new EnglishSolitaireModel(4, 4);
  MarbleSolitaireModel boardSeven = new EnglishSolitaireModel(7, 10, 6);

  @Test
  public void testThreeArgumentConstructor() {
    // boardSeven is an example of a 3 argument constructor, for it,
    // the constructor should create a board of size 19, score of 216
    // with an empty slot at (10,6) and a marble at every valid slot it is given on the board with
    // off board slots on the board showing a SlotState.Invalid. We can check this using methods
    // from the MarbleSolitaireModel interface
    assertEquals(19, boardSeven.getBoardSize());
    assertEquals(216, boardSeven.getScore());
    assertEquals(SlotState.Empty, boardSeven.getSlotAt(10, 6));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(18, 18));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(13, 13));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(5, 13));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(13, 5));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(0, 6));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(12, 8));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(18, 11));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(8, 18));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(7, 3));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(9, 0));

    // Error test here
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(8, 10, 6);
      fail("No exception thrown for invalid thickness");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(8, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(1, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(-1, -3, -3);
      fail("No exception thrown for invalid thickness, sRow, or sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(7, -4, 2);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(7, 0, 0);
      fail("No exception thrown for invalid sRow and sCol, even if present within grid as not on " +
          "game board");
    } catch (Exception e) {
      // works as expected
    }

    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(5, 4, 14);
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
    assertEquals(13, boardFive.getBoardSize());
    assertEquals(104, boardFive.getScore());
    assertEquals(SlotState.Empty, boardFive.getSlotAt(6, 6));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(12, 12));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(9, 9));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(3, 9));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(9, 3));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(0, 5));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(12, 6));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(1, 8));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(7, 12));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(8, 9));

    // Error test here
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(10);
      fail("No exception thrown for odd thickness");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(1);
      fail("No exception thrown for invalid thickness");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(-1);
      fail("No exception thrown for negative thickness");
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
    assertEquals(7, boardFourFour.getBoardSize());
    assertEquals(32, boardFourFour.getScore());
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(6, 6));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(4, 0));

    // Error test here
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(-2, 3);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(2, -4);
      fail("No exception thrown for invalid sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(8, 3);
      fail("No exception thrown for invalid sRow");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(2, 9);
      fail("No exception thrown for invalid sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(5, 6);
      fail("No exception thrown for invalid sRow and sCol");
    } catch (Exception e) {
      // works as expected
    }
    try {
      EnglishSolitaireModel boardSeven = new EnglishSolitaireModel(0, 0);
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
    assertEquals(7, boardThree.getBoardSize());
    assertEquals(32, boardThree.getScore());
    assertEquals(SlotState.Empty, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(6, 6));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(4, 0));

  }


  @Test
  public void testMove() {
    // Testing a move on an EnglishSolitaireModel created using the default constructor
    assertEquals(SlotState.Empty, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 1));
    assertEquals(32, boardThree.getScore());
    boardThree.move(3, 1, 3, 3);
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, boardThree.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, boardThree.getSlotAt(3, 1));
    assertEquals(31, boardThree.getScore());

    // Testing a move on an EnglishSolitaireModel created using the constructor taking in one
    // argument
    assertEquals(SlotState.Empty, boardFive.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(6, 5));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(6, 4));
    assertEquals(104, boardFive.getScore());
    boardFive.move(6, 4, 6, 6);
    assertEquals(SlotState.Marble, boardFive.getSlotAt(6, 6));
    assertEquals(SlotState.Empty, boardFive.getSlotAt(6, 5));
    assertEquals(SlotState.Empty, boardFive.getSlotAt(6, 4));
    assertEquals(103, boardFive.getScore());

    // Testing a move on an EnglishSolitaireModel created using the constructor taking in two
    // arguments
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(2, 4));
    assertEquals(32, boardFourFour.getScore());
    boardFourFour.move(2, 4, 4, 4);
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(4, 4));
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(3, 4));
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(2, 4));
    assertEquals(31, boardFourFour.getScore());

    // Testing a move on an EnglishSolitaireModel created using the constructor taking in three
    // arguments
    assertEquals(SlotState.Empty, boardSeven.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(9, 6));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(8, 6));
    assertEquals(216, boardSeven.getScore());
    boardSeven.move(8, 6, 10, 6);
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(10, 6));
    assertEquals(SlotState.Empty, boardSeven.getSlotAt(9, 6));
    assertEquals(SlotState.Empty, boardSeven.getSlotAt(8, 6));
    assertEquals(215, boardSeven.getScore());

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
    boardThree.move(3, 1, 3, 3);
    boardThree.move(1, 2, 3, 2);
    boardThree.move(3, 3, 3, 1);
    boardThree.move(1, 3, 3, 3);
    boardThree.move(3, 4, 3, 2);
    boardThree.move(3, 6, 3, 4);
    boardThree.move(2, 0, 2, 2);
    boardThree.move(3, 2, 1, 2);
    boardThree.move(0, 2, 2, 2);
    boardThree.move(0, 4, 0, 2);
    boardThree.move(2, 5, 2, 3);
    boardThree.move(2, 2, 2, 4);
    boardThree.move(2, 4, 0, 4);
    boardThree.move(3, 0, 3, 2);
    boardThree.move(4, 2, 2, 2);
    boardThree.move(4, 0, 4, 2);
    boardThree.move(4, 4, 2, 4);
    boardThree.move(4, 2, 4, 4);
    boardThree.move(4, 5, 4, 3);
    boardThree.move(5, 3, 3, 3);
    boardThree.move(6, 2, 4, 2);
    boardThree.move(6, 4, 6, 2);
    assertEquals(true, boardThree.isGameOver());

    assertEquals(false, boardFourFour.isGameOver());
    boardFourFour.move(2, 4, 4, 4);
    boardFourFour.move(2, 2, 2, 4);
    boardFourFour.move(0, 2, 2, 2);
    boardFourFour.move(0, 4, 0, 2);
    boardFourFour.move(2, 1, 2, 3);
    boardFourFour.move(4, 1, 2, 1);
    boardFourFour.move(4, 3, 4, 1);
    boardFourFour.move(4, 5, 4, 3);
    boardFourFour.move(4, 0, 4, 2);
    boardFourFour.move(2, 0, 2, 2);
    boardFourFour.move(2, 3, 2, 1);
    boardFourFour.move(1, 4, 1, 2);
    boardFourFour.move(0, 2, 2, 2);
    boardFourFour.move(2, 2, 2, 0);
    boardFourFour.move(2, 0, 4, 0);
    boardFourFour.move(2, 5, 2, 3);
    boardFourFour.move(3, 3, 1, 3);
    boardFourFour.move(3, 6, 3, 4);
    boardFourFour.move(4, 2, 2, 2);
    boardFourFour.move(6, 2, 4, 2);
    boardFourFour.move(6, 4, 4, 4);
    boardFourFour.move(4, 3, 4, 1);
    boardFourFour.move(4, 0, 4, 2);
    boardFourFour.move(4, 4, 2, 4);
    boardFourFour.move(6, 3, 4, 3);
    boardFourFour.move(4, 2, 4, 4);
    assertEquals(true, boardFourFour.isGameOver());

    assertEquals(false, boardFive.isGameOver());
    assertEquals(false, boardSeven.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, boardThree.getBoardSize());
    assertEquals(13, boardFive.getBoardSize());
    assertEquals(7, boardFourFour.getBoardSize());
    assertEquals(216, boardSeven.getScore());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(2, 2));
    assertEquals(SlotState.Empty, boardThree.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, boardThree.getSlotAt(3, 4));
    assertEquals(SlotState.Invalid, boardThree.getSlotAt(6, 6));

    assertEquals(SlotState.Invalid, boardFive.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, boardFive.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(7, 6));
    assertEquals(SlotState.Invalid, boardFive.getSlotAt(10, 10));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(8, 9));
    assertEquals(SlotState.Marble, boardFive.getSlotAt(6, 2));

    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, boardFourFour.getSlotAt(3, 6));
    assertEquals(SlotState.Invalid, boardFourFour.getSlotAt(6, 6));
    assertEquals(SlotState.Empty, boardFourFour.getSlotAt(4, 4));

    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, boardSeven.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, boardSeven.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(7, 6));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(10, 10));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(8, 9));
    assertEquals(SlotState.Marble, boardSeven.getSlotAt(6, 2));

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
    assertEquals(32, boardThree.getScore());
    boardThree.move(3, 1, 3, 3);
    assertEquals(31, boardThree.getScore());
    boardThree.move(1, 2, 3, 2);
    assertEquals(30, boardThree.getScore());

    assertEquals(104, boardFive.getScore());
    boardFive.move(6, 4, 6, 6);
    assertEquals(103, boardFive.getScore());
    boardFive.move(4, 5, 6, 5);
    assertEquals(102, boardFive.getScore());

    assertEquals(32, boardFourFour.getScore());
    boardFourFour.move(4, 2, 4, 4);
    assertEquals(31, boardFourFour.getScore());
    boardFourFour.move(2, 3, 4, 3);
    assertEquals(30, boardFourFour.getScore());

    assertEquals(216, boardSeven.getScore());
    boardSeven.move(8, 6, 10, 6);
    assertEquals(215, boardSeven.getScore());
    boardSeven.move(6, 6, 8, 6);
    assertEquals(214, boardSeven.getScore());
  }


}