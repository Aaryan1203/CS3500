import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw03.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.hw03.EnglishSolitaireTextView;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireView;
import cs3500.marblesolitaire.view.hw04.EuropeanSolitaireTextView;
import cs3500.marblesolitaire.view.hw04.TriangleSolitaireTextView;

/**
 * Main method tester for code
 *
 * @author zindagikamra
 * @author aaryan1203
 */
public final class MarbleSolitaireMain {

  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new EnglishSolitaireTextView(model);
    switch (args[0]) {
      case "english":
        try {
          if (args[1].equals("-size")) {
            int size = Integer.parseInt(args[2]);
            try {
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new EnglishSolitaireModel(size);
            }
          } else if (args[1].equals("-hole")) {
            int row = Integer.parseInt(args[2]);
            int col = Integer.parseInt(args[3]);
            try {
              int size = Integer.parseInt(args[5]);
              model = new EnglishSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new EnglishSolitaireModel(row, col);
            }
          }

        } catch (Exception e) {
          model = new EnglishSolitaireModel();
        }
        view = new EnglishSolitaireTextView(model);
        break;
      case "european":
        try {
          if (args[1].equals("-size")) {
            int size = Integer.parseInt(args[2]);
            try {
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new EuropeanSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new EuropeanSolitaireModel(size);
            }
          } else if (args[1].equals("-hole")) {
            int row = Integer.parseInt(args[2]);
            int col = Integer.parseInt(args[3]);
            try {
              int size = Integer.parseInt(args[5]);
              model = new EuropeanSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new EuropeanSolitaireModel(row, col);
            }
          }

        } catch (Exception e) {
          model = new EuropeanSolitaireModel();
        }
        view = new EuropeanSolitaireTextView(model);
        break;
      case "triangular":
        try {
          if (args[1].equals("-size")) {
            int size = Integer.parseInt(args[2]);
            try {
              int row = Integer.parseInt(args[4]);
              int col = Integer.parseInt(args[5]);
              model = new TriangleSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new TriangleSolitaireModel(size);
            }
          } else if (args[1].equals("-hole")) {

            int row = Integer.parseInt(args[2]);
            int col = Integer.parseInt(args[3]);
            try {
              int size = Integer.parseInt(args[5]);
              model = new TriangleSolitaireModel(size, row, col);
            } catch (Exception f) {
              model = new TriangleSolitaireModel(row, col);
            }
          }

        } catch (Exception e) {
          model = new TriangleSolitaireModel();
        }
        view = new TriangleSolitaireTextView(model);
        break;
      default:
        // nothing :(
    }

    MarbleSolitaireController controller =
        new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
    controller.playGame();
  }
}