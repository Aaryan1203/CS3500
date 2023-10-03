package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a triangle solitaire model
 */
public class TriangleSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Constructs a {@code TriangleSolitaireModel} object
   *
   * @param dimension number of rows of the board
   * @param sRow      the row index for the starting empty slot
   * @param sCol      the column index for the starting empty slot, must be valid position on board
   * @throws IllegalArgumentException if given negative dimention, or invalid sRow and sCol for
   *                                  empty slot
   */
  public TriangleSolitaireModel(int dimension, int sRow, int sCol) {
    super(dimension, sRow, sCol);
    for (int i = 1; i <= dimension; i++) {
      this.score += i;
    }
    this.score -= 1;
    this.boardSize = dimension;
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object with 5 rows, and index of the empty slot at
   * (0, 0)
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object with the given rows, and index of the empty
   *
   * @param dimension the number of rows for the game
   * @throws IllegalArgumentException if the dimension is negative
   */
  public TriangleSolitaireModel(int dimension) throws IllegalArgumentException {
    this(dimension, 0, 0);

  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object with the 5 rows, and index of the empty slot
   * at the given coordinates
   *
   * @param sRow the row of the empty cell
   * @param sCol the column of the empty cell
   * @throws IllegalArgumentException if the empty slot is not at a valid position
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5, sRow, sCol);
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible due to pieces being off board
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    super.move(fromRow, fromCol, toRow, toCol);
    if (fromCol != toCol && fromRow != toRow) {
      board[(fromRow + toRow) / 2][(toCol + fromCol) / 2] = SlotState.Empty;
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    for (int i = 0; i < this.boardSize; i++) {
      for (int j = 0; j < this.boardSize; j++) {
        if (j - 2 >= 0 && i - 2 >= 0 && validMove(i, j, i - 2, j - 2)) {
          return false;
        }
        if (j + 2 < this.boardSize && i + 2 < this.boardSize && validMove(i, j, i + 2, j + 2)) {
          return false;
        }
      }
    }
    return super.isGameOver();
  }

  /**
   * Determines if the given indexes are a valid amount away from each other for a move to be made
   * with their center SlotState being a SlotState.Marble
   *
   * @param fromRow row to move from
   * @param toRow   row to move to
   * @param fromCol col to move from
   * @param toCol   col to move to
   * @return if the given distance between slots is valid for a move
   */
  protected boolean isCorrectDistance(int fromRow, int toRow, int fromCol, int toCol) {
    return super.isCorrectDistance(fromRow, toRow, fromCol, toCol) ||
        (Math.abs(fromCol - toCol) == 2 && Math.abs(toRow - fromRow) == 2
            && this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2] == SlotState.Marble);
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
    return col <= row && row < this.boardSize;
  }
}
