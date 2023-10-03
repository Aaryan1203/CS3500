package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;

/**
 * Represents a marble solitaire model
 */
public abstract class AMarbleSolitaireModel implements MarbleSolitaireModel {

  protected SlotState[][] board;
  protected int boardSize;
  protected int score;
  protected final int sideLength;
  protected final int sRow;
  protected final int sCol;

  /**
   * Constructs a {@code AMarbleSolitaireModel} object
   *
   * @param sideLength thickness of 1 side of the board, must be a positive, odd number
   * @param sRow       the row index for the starting empty slot
   * @param sCol       the column index for the starting empty slot, must be valid position on
   *                   board
   * @throws IllegalArgumentException if given odd or negative thickness, or invalid sRow and sCol
   *                                  for empty slot
   */
  public AMarbleSolitaireModel(int sideLength, int sRow, int sCol) {
    // checking validity of and setting thickness of arm.
    if (sideLength < 2 || sideLength % 2 == 0) {
      throw new IllegalArgumentException("Invalid thickness, must be a positive and odd number.");
    }
    this.sideLength = sideLength;
    this.boardSize = sideLength * 3 - 2;
    this.board = new SlotState[boardSize][boardSize];

    if (this instanceof TriangleSolitaireModel) {
      this.boardSize = sideLength;
    }

    // checking validity of and setting empty slot location.
    if (!this.validIndex(sRow, sCol)) {
      throw new
          IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }

    this.sRow = sRow;
    this.sCol = sCol;

    // Creating board.
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (this.validIndex(i, j)) {
          board[i][j] = SlotState.Marble;
        } else {
          board[i][j] = SlotState.Invalid;
        }
      }
    }
    board[sRow][sCol] = SlotState.Empty;

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
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      score--;
      board[fromRow][fromCol] = SlotState.Empty;
      board[toRow][toCol] = SlotState.Marble;
      if (fromRow == toRow) {
        board[fromRow][(toCol + fromCol) / 2] = SlotState.Empty;
      }
      if (fromCol == toCol) {
        board[(fromRow + toRow) / 2][toCol] = SlotState.Empty;
      }
    } else {
      throw new IllegalArgumentException(
          "Invalid move from (" + fromRow + ","
              + fromCol + ") to (" + toRow + "," + toCol + ")");
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    if (score == 1 && board[sRow][sCol].equals(SlotState.Marble)) {
      return true;
    }

    for (int i = 0; i < this.boardSize; i++) {
      for (int j = 0; j < this.boardSize; j++) {
        if (i - 2 >= 0 && validMove(i, j, i - 2, j)) {
          return false;
        }
        if (j - 2 >= 0 && validMove(i, j, i, j - 2)) {
          return false;
        }
        if (i + 2 < this.boardSize && validMove(i, j, i + 2, j)) {
          return false;
        }
        if (j + 2 < this.boardSize && validMove(i, j, i, j + 2)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the size of the board
   *
   * @return the size of the board
   */
  @Override
  public int getBoardSize() {
    return this.boardSize;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond the dimensions of the
   *                                  board
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= this.boardSize || col < 0 || col >= this.boardSize) {
      throw new
          IllegalArgumentException("Cannot use invalid slot index: (" + row + ", " + col + ")");
    }
    return this.board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return this.score;
  }

  /**
   * Determines if a given move from a from-index to a to-index is valid and can be played
   *
   * @param fromRow the row index of the position you are moving the marble from
   * @param fromCol the column index of the position you are moving the marble from
   * @param toRow   the row index of the position you are moving the marble to
   * @param toCol   the column index of the position you are moving the marble to
   * @return returns if the given move is valid and can be done in the form of a boolean
   * @throws IllegalArgumentException if given out of bounds index
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {

    return validIndex(fromRow, fromCol) && validIndex(toRow, toCol)
        && this.getSlotAt(fromRow, fromCol).equals(SlotState.Marble)
        && this.getSlotAt(toRow, toCol).equals(SlotState.Empty)
        && this.isCorrectDistance(fromRow, toRow, fromCol, toCol);
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
    return ((fromRow == toRow && Math.abs(fromCol - toCol) == 2
        && this.board[fromRow][(fromCol + toCol) / 2] == SlotState.Marble)
        || (toCol == fromCol && Math.abs(toRow - fromRow) == 2
        && this.board[(toRow + fromRow) / 2][toCol] == SlotState.Marble));
  }

  /**
   * Checks if given index through row and column is a valid index on the game board
   *
   * @param row row index you are checking to be valid on board, must be an integer
   * @param col col index you are checking to be valid on board, must be an integer
   * @return returns if the given index is valid on the board in the form of a boolean
   */
  protected abstract boolean validIndex(int row, int col);

}
