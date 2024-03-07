package no.ntnu.idatx2003.oblig3.cardgame;
import java.util.ArrayList;
public class Hand {
  private ArrayList<String> cards;

  public Hand(ArrayList<String> cards) {
    this.cards = cards;
  }

  public void displayHand() {
    for (String card : cards) {
      System.out.println(card + " ");
    }
  }

}
