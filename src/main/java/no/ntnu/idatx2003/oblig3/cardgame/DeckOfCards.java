package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private ArrayList<String> cards;

  public DeckOfCards() {
    this.cards = new ArrayList<>();

    // Adds all the cards to the deck.
    for (char suit : suits) {
      for (int rank = 1; rank <= 13; rank++) {
        String card = getCardString(rank, suit);
        this.cards.add(card);
      }
    }
  }

  private String getCardString(int rank, char suit) {
    // Convert numbervalue to cardvalue
    String rankString = switch (rank) {
      case 1 -> "A";
      case 11 -> "J";
      case 12 -> "Q";
      case 13 -> "K";
      default -> Integer.toString(rank);
    };

    // Returns the card as a string
    return rankString + suit;
  }

}
