import cs3500.marblesolitaire.model.hw03.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.hw03.MarbleSolitaireTextView;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw04TypeChecks {

  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helperMarble(new EnglishSolitaireModel(),
        rd, ap);

    helperTriangle(new TriangleSolitaireModel(3, 3),
        rd, ap);
  }

  private static void helperMarble
      (cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel model,
          Readable rd,Appendable ap) {
    new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(model,
        new MarbleSolitaireTextView(model,ap),rd);
  }

  private static void helperTriangle
      (cs3500.marblesolitaire.model.hw03.MarbleSolitaireModel model,
          Readable rd,Appendable ap) {
    new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(model,
        new MarbleSolitaireTextView(model,ap),rd);
  }

}
