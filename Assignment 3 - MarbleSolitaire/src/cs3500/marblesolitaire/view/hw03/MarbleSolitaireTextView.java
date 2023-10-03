package cs3500.marblesolitaire.view.hw03;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState.SlotState;

/**
 * Represents a game of Marble Solitaire's visualization
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState board;
  protected Appendable destination;

  /**
   * Constructs a {@code MarbleSolitaireTextView} object
   *
   * @param board the game model of the marble solitaire game which is given to be visualized,
   *              cannot be null, must be a valid MarbleSolitaireModelState
   * @throws IllegalArgumentException if given null board as parameter
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board) throws IllegalArgumentException {
    this(board, System.out);
  }

  /**
   * Constructs a {@code MarbleSolitaireTextView} object
   *
   * @param board       the game model of the marble solitaire game which is given to be visualized,
   *                    cannot be null, must be a valid MarbleSolitaireModelState
   * @param destination the appendable object to transmit the visualization to
   * @throws IllegalArgumentException if given null board or null appendable as parameter
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board, Appendable destination)
      throws IllegalArgumentException {
    if (board == null) {
      throw new IllegalArgumentException("Cannot visualize null board");
    }
    if (destination == null) {
      throw new IllegalArgumentException("Cannot transmit board to null location");
    }
    this.board = board;
    this.destination = destination;
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
    StringBuilder game = new StringBuilder();
    for (int i = 0; i < board.getBoardSize(); i++) {
      for (int j = 0; j < board.getBoardSize(); j++) {
        if (board.getSlotAt(i, j).equals(SlotState.Marble)) {
          if (!board.getSlotAt(i, (j + 1) % board.getBoardSize()).equals(SlotState.Invalid)) {
            game.append("O ");
          } else {
            game.append("O");
          }
        }
        if (board.getSlotAt(i, j).equals(SlotState.Empty)) {
          if (!board.getSlotAt(i, (j + 1) % board.getBoardSize()).equals(SlotState.Invalid)) {
            game.append("_ ");
          } else {
            game.append("_");
          }

        }
        if (j == board.getBoardSize() - 1 && !board.getSlotAt(i, j).equals(SlotState.Invalid)) {
          game = new StringBuilder(game.substring(0, game.length() - 1));
          game.append("\n");
        }
        if (board.getSlotAt(i, j).equals(SlotState.Invalid)
            && j < board.getBoardSize() / 2) {
          game.append("  ");
        }
        if (board.getSlotAt(i, j).equals(SlotState.Invalid)
            && j > board.getBoardSize() / 2 && i != board.getBoardSize() - 1) {
          game.append("\n");
          j = board.getBoardSize();
        }
      }
    }
    return game.toString();
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly in the
   * format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    try {
      destination.append(this.toString());
    } catch (IOException e) {
      throw new IOException("Destination not found to transmit to");
    }

  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      destination.append(message);
    } catch (IOException e) {
      throw new IOException("Destination not found to transmit to");
    }

  }
}