package cs3500.marblesolitaire.controller;

import java.util.Scanner;

import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireView;

/**
 * Represents the controller for a game of Marble Solitaire
 *
 * @author aaryan1203
 * @author zindagikamra
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel game;
  private MarbleSolitaireView board;
  private Scanner toRead;
  private boolean quit = false;

  /**
   * Creates a {@code MarbleSolitaireControllerImpl} objec
   *
   * @param game   game of Marble Solitaire being played
   * @param board  visualizer for game of MarbleSolitaire
   * @param toRead Readable to receive input from
   * @throws IllegalArgumentException if any of given fields null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel game,
      MarbleSolitaireView board, Readable toRead)
      throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("Given game cannot be null");
    }
    if (board == null) {
      throw new IllegalArgumentException("Given board visualizer cannot be null");
    }
    if (toRead == null) {
      throw new IllegalArgumentException("Given move file cannot be null");
    }
    this.board = board;
    this.game = game;
    this.toRead = new Scanner(toRead);

  }

  /**
   * plays game of marble solitaire by taking described integer one at a time
   *
   * @throws IllegalStateException if the controller is unable to successfully read input or
   *                               transmit output
   */
  @Override
  public void playGame() throws IllegalStateException {
    while (!this.game.isGameOver() && !quit) {
      try {
        this.board.renderBoard();
      } catch (Exception e) {
        throw new IllegalStateException("Cannot transmit board");
      }

      try {
        this.board.renderMessage("\nScore: " + this.game.getScore() + "\n");
      } catch (Exception e) {
        throw new IllegalStateException("Cannot transmit score");
      }

      boolean moveMade = false;
      while (!moveMade) {
        int fromRow = validNum("From Row: ") - 1;
        int fromCol = validNum("From Col: ") - 1;
        int toRow = validNum("To Row: ") - 1;
        int toCol = validNum("To Col: ") - 1;

        if (quit) {
          break;
        }

        try {
          this.game.move(fromRow, fromCol, toRow, toCol);
          moveMade = true;
        } catch (Exception e) {
          try {
            this.board.renderMessage("Invalid indexes given for move, please re-enter values:\n");
          } catch (Exception f) {
            throw new IllegalStateException("Cannot transmit invalid move message");
          }
        }
      }
    }
    if (!quit) {
      try {
        this.board.renderMessage("Game over!\n");
        this.board.renderBoard();
        this.board.renderMessage("\nScore: " + this.game.getScore());
      } catch (Exception e) {
        throw new IllegalStateException("Cannot transmit Game End");
      }
    } else {
      try {
        this.board.renderMessage("Game quit!\nState of game when quit:\n");
        this.board.renderBoard();
        this.board.renderMessage("\nScore: " + this.game.getScore());
      } catch (Exception e) {
        throw new IllegalStateException("Cannot transmit Quit Game");
      }
    }

  }

  /**
   * returns valid int to be used for move in playGame when found
   *
   * @param description describes what aspect of the move the program is asking index for
   * @return valid index number when found
   * @throws IllegalStateException if any transmission to appendable or read from readable given
   *                               fails
   */
  private int validNum(String description) throws IllegalStateException {
    if (!quit) {
      try {
        this.board.renderMessage(description);
      } catch (Exception e) {
        throw new IllegalStateException("Cannot transmit to board");
      }

      int validNumSet = 0;
      while (validNumSet < 1) {
        String num = toRead.nextLine();
        if (num.toLowerCase().equals("q")) {
          quit = true;
          break;
        }
        try {
          if (Integer.parseInt(num) > 0) {
            validNumSet = Integer.parseInt(num);
          } else {
            throw new IllegalStateException("Cannot have 0 or less than 0 index");
          }

        } catch (Exception e) {
          try {
            this.board.renderMessage("Invalid index\n");
            this.board.renderMessage(description);
          } catch (Exception f) {
            throw new IllegalStateException("Cannot transmit to board");
          }

        }
      }
      return validNumSet;
    }
    return 0;
  }
}