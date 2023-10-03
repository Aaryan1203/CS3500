package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.view.hw03.EnglishSolitaireTextView;
import java.io.InputStreamReader;
import cs3500.marblesolitaire.model.hw03.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireTextView;

/**
 * Tests playGame method in MarbleSolitaireController by running it
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public class Main {

  public static void main(String[] args) {
    EnglishSolitaireModel game = new EnglishSolitaireModel(5);
    MarbleSolitaireTextView board = new EnglishSolitaireTextView(game);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, board,
        new InputStreamReader(System.in));

    // Running test for playGame
    controller.playGame();
  }
}