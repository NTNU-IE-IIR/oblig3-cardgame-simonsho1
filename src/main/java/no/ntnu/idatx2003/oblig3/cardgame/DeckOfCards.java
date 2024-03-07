package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

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

  public ArrayList<String> dealHand(int n) {
    // Draws random n cards from the deck
    Random random = new Random();
    Collections.shuffle(cards);
    ArrayList<String> hand = new ArrayList<>(cards.subList(0, n));
    cards.removeAll(hand);
    return hand;
  }

}
