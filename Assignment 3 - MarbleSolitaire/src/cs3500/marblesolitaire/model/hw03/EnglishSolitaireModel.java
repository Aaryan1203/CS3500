// Aaryan Jain and Zindagi Kamra
package cs3500.marblesolitaire.model.hw03;

import cs3500.marblesolitaire.model.hw04.AMarbleSolitaireModel;

/**
 * Class representing an English Solitaire Game along with its attributes and abilities
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class EnglishSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Constructs a {@code EnglishSolitaireModel} object
   *
   * @param sideLength thickness of 1 side of the board, must be a positive, odd number
   * @param sRow       the row index for the starting empty slot
   * @param sCol       the column index for the starting empty slot, must be valid position on
   *                   board
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EnglishSolitaireModel(int sideLength, int sRow, int sCol) throws IllegalArgumentException {
    super(sideLength, sRow, sCol);
    this.score = 4 * (sideLength * sideLength) + (sideLength - 2) * (sideLength - 2) - 5;

  }

  /**
   * Constructs a {@code EnglishSolitaireModel} object with thickness 3, and index of the empty slot
   * at (3,3)
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs a {@code EnglishSolitaireModel} object with thickness 3 and specified empty starting
   * index
   *
   * @param sRow the row index for the starting empty slot, must be valid position on board
   * @param sCol the column index for the starting empty slot, must be valid position on board
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);

  }

  /**
   * Constructs a {@code EnglishSolitaireModel} object with the starting empty slot at the center of
   * the game board
   *
   * @param thickness thickness of 1 side of the board, must be a positive, odd number
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EnglishSolitaireModel(int thickness) throws IllegalArgumentException {
    this(thickness, (thickness * 3 - 2) / 2, (thickness * 3 - 2) / 2);
  }

  /**
   * Checks if given index through row and column is a valid index on the game board
   *
   * @param row row index you are checking to be valid on board, must be an integer
   * @param col col index you are checking to be valid on board, must be an integer
   * @return returns if the given index is valid on the board in the form of a boolean
   * @throws IllegalArgumentException if given index is off of the board entirely
   */
  protected boolean validIndex(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= this.boardSize || col < 0 || col >= this.boardSize) {
      throw new
          IllegalArgumentException("Cannot use invalid slot index: ("
          + row + ", " + col + ")");
    }
    return ((row > sideLength - 2 && row < this.boardSize - (sideLength - 1) && col >= 0
        && col < boardSize) ||
        (col > sideLength - 2 && col < this.boardSize - (sideLength - 1) && row >= 0
            && row < boardSize));
  }
}