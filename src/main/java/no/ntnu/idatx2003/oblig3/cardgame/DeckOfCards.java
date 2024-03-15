package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.*;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private static ArrayList<String> cards;



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

  public void dealHand(int numberOfCards) {
    // Shuffles the deck
    Collections.shuffle(this.cards);

    // Deals the hand
    for (int i = 0; i < numberOfCards; i++) {
      System.out.println(this.cards.get(i));
    }
  }

    public static List<String> getHand() {
        // Returns the hand
        return cards.subList(0, 5);
    }
  public void checkHand() {
    // Checks the hand for Queen of Spades, Five cards of the same suit.
    List<String> hand = DeckOfCards.getHand();
    int sum = 0;
    int hearts = 0;
    boolean queenOfSpades = false;
    boolean flush = false;
    Map<Character, Integer> suitsCount = new HashMap<>();

    for (String card : hand) {
      char suit = card.charAt(card.length() - 1);
      int value = getValue(card.substring(0, card.length() - 1));

      if (suit == 'S' && card.startsWith("Q")) {
        queenOfSpades = true;
      }

      sum += value;

      if (suit == 'H') {
        hearts++;
      }

        suitsCount.put(suit, suitsCount.getOrDefault(suit, 0) + 1);
    }

    boolean sameSuit = suitsCount.size() == 1;
    String result = "Flush: " + sameSuit + "\nQueen of Spades: " + queenOfSpades +
            "\nSum: " + sum + "\nHearts Count: " + hearts;
    System.out.println(result);
  }


  private int getValue(String rank) {
    // Converts the cardvalue to a numbervalue
    switch (rank) {
      case "2" -> {
        return 2;
      }
      case "3" -> {
        return 3;
      }
      case "4" -> {
        return 4;
      }
      case "5" -> {
        return 5;
      }
      case "6" -> {
        return 6;
      }
      case "7" -> {
        return 7;
      }
      case "8" -> {
        return 8;
      }
      case "9" -> {
        return 9;
      }
      case "10" -> {
        return 10;
      }
      case "J" -> {
        return 11;
      }
      case "Q" -> {
        return 12;
      }
      case "K" -> {
        return 13;
      }
      case "A" -> {
        return 1;
      }
      default -> {
        return 0;
      }
    }
  }

}
