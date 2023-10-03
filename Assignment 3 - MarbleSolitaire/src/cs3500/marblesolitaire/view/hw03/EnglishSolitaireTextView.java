package cs3500.marblesolitaire.view.hw03;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModelState;

/**
 * Creates an instance of the English Solitaire Text View class
 * <p>
 * Changed this to extend the MarbleSolitaireTextView class in order to abstract some of the same
 * methods for the other text view classes
 */
public class EnglishSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructs a {@code EnglishSolitaireTextView} object
   *
   * @param board       the game model of the marble solitaire game which is given to be visualized,
   *                    cannot be null, must be a valid MarbleSolitaireModelState
   * @param destination the appendable object to transmit the visualization to
   * @throws IllegalArgumentException if given null board or null appendable as parameter
   */
  public EnglishSolitaireTextView(MarbleSolitaireModelState board, Appendable destination) {
    super(board, destination);
  }

  /**
   * Constructs a {@code EnglishSolitaireTextView} object
   *
   * @param board the game model of the marble solitaire game which is given to be visualized,
   *              cannot be null, must be a valid MarbleSolitaireModelState
   * @throws IllegalArgumentException if given null board as parameter
   */
  public EnglishSolitaireTextView(MarbleSolitaireModelState board) throws IllegalArgumentException {
    this(board, System.out);
  }

}
