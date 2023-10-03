package cs3500.marblesolitaire.view.hw04;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireTextView;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState.SlotState;


/**
 * Represents a Triangle Solitaire Text View
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructs a {@code TriangleSolitaireTextView} object
   *
   * @param board       the game model of the marble solitaire game which is given to be visualized,
   *                    cannot be null, must be a valid MarbleSolitaireModelState
   * @param destination the appendable object to transmit the visualization to
   * @throws IllegalArgumentException if given null board or null appendable as parameter
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board, Appendable destination) {
    super(board, destination);
  }

  /**
   * Constructs a {@code TriangleSolitaireTextView} object
   *
   * @param board the game model of the marble solitaire game which is given to be visualized,
   *              cannot be null, must be a valid MarbleSolitaireModelState
   * @throws IllegalArgumentException if given null board as parameter
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board)
      throws IllegalArgumentException {
    this(board, System.out);
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, _ or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    StringBuilder boardText = new StringBuilder();

    String emptySpace = " ";
    for (int i = 0; i < board.getBoardSize(); i++) {
      boardText.append(emptySpace.repeat((board.getBoardSize() - (i + 1))));
      for (int j = 0; j < i + 1; j++) {
        if (board.getSlotAt(i, j) == SlotState.Marble) {
          boardText.append("0 ");
        } else if (board.getSlotAt(i, j) == SlotState.Empty) {
          boardText.append("_ ");
        }

      }
      boardText = new StringBuilder(boardText.toString().substring(0, boardText.length() - 1));
      boardText.append("\n");
    }
    boardText = new StringBuilder(boardText.toString().substring(0, boardText.length() - 1));
    return boardText.toString();

  }
}