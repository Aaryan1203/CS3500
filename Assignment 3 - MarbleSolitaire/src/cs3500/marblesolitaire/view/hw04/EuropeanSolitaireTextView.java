package cs3500.marblesolitaire.view.hw04;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireTextView;

/**
 * Represents a view for a European Solitaire game
 */
public class EuropeanSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructs a {@code EuropeanSolitaireTextView} object
   *
   * @param board       the game model of the marble solitaire game which is given to be visualized,
   *                    cannot be null, must be a valid MarbleSolitaireModelState
   * @param destination the appendable object to transmit the visualization to
   * @throws IllegalArgumentException if given null board or null appendable as parameter
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState board, Appendable destination) {
    super(board, destination);
  }

  /**
   * Constructs a {@code EuropeanSolitaireTextView} object
   *
   * @param board the game model of the marble solitaire game which is given to be visualized,
   *              cannot be null, must be a valid MarbleSolitaireModelState
   * @throws IllegalArgumentException if given null board as parameter
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState board)
      throws IllegalArgumentException {
    this(board, System.out);
  }
}
