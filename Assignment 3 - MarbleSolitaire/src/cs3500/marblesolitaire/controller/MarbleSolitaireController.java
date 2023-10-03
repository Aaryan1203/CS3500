package cs3500.marblesolitaire.controller;

/**
 * This interface represents a controller for the Marble Solitaire game
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire
   *
   * @throws IllegalArgumentException if the controller is unable to successfully read input or
   *                                  transmit output
   */
  void playGame() throws IllegalArgumentException;
}
