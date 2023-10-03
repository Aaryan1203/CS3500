package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;

/**
 * Represents a European o solitaire model
 */
public class EuropeanSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Constructs a {@code EuropeanSolitaireModel} object
   *
   * @param sideLength thickness of 1 side of the board, must be a positive, odd number
   * @param sRow       the row index for the starting empty slot
   * @param sCol       the column index for the starting empty slot, must be valid position on
   *                   board
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol)
      throws IllegalArgumentException {
    super(sideLength, sRow, sCol);
    this.score = 4 * (sideLength * sideLength) + (sideLength - 2) * (sideLength - 2) - 5;
    for (int i = 1; i <= sideLength - 2; i++) {
      this.score += i * 4;
    }
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with thickness 3, and index of the empty
   * slot at (3,3)
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with thickness 3 and specified empty
   * starting index
   *
   * @param sRow the row index for the starting empty slot, must be valid position on board
   * @param sCol the column index for the starting empty slot, must be valid position on board
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);

  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with the starting empty slot at the center
   * of the game board
   *
   * @param sideLength thickness of 1 side of the board, must be a positive, odd number
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {
    this(sideLength, (sideLength * 3 - 2) / 2, (sideLength * 3 - 2) / 2);
  }

  /**
   * Checks if given index through row and column is a valid index on the game board
   *
   * @param row row index you are checking to be valid on board, must be an integer
   * @param col col index you are checking to be valid on board, must be an integer
   * @return returns if the given index is valid on the board in the form of a boolean
   */
  @Override
  protected boolean validIndex(int row, int col) {
    if (row < 0 || row >= this.boardSize || col < 0 || col >= this.boardSize) {
      throw new
          IllegalArgumentException("Cannot use invalid slot index: ("
          + row + ", " + col + ")");
    }
    if (row < sideLength - 1) {
      return (col > (boardSize / 2 - (sideLength + 2 * row) / 2) - 1) &&
          (col < (boardSize / 2 + (sideLength + 2 * row) / 2) + 1);
    } else if (row >= sideLength * 2 - 1) {
      int calculatedRow = (boardSize - 1) - row;
      return (col > (boardSize / 2 - (sideLength + 2 * calculatedRow) / 2) - 1) &&
          (col < (boardSize / 2 + (sideLength + 2 * calculatedRow) / 2) + 1);
    }
    return true;
  }

}

