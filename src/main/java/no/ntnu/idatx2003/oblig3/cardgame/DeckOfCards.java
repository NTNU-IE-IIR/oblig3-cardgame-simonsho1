package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.*;
import java.util.stream.Collectors;

/** Represents a deck of cards. A deck of cards contains 52 cards, with 4 suits and 13 ranks. */
public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private static ArrayList<String> cards;

  /** Initializes a new deck of cards with 52 cards. */
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

  // Private helpoer method to get the string representation of a card
  private String getCardString(int rank, char suit) {
    // Convert numbervalue to cardvalue
    String rankString =
        switch (rank) {
          case 1 -> "1";
          case 11 -> "11";
          case 12 -> "12";
          case 13 -> "13";
          default -> Integer.toString(rank);
        };

    // Returns the card as a string
    return suit + rankString;
  }

  /**
   * Deals a hand of cards from the deck.
   *
   * @param numberOfCards the number of cards to deal.
   */
  public void dealHand(int numberOfCards) {
    // Shuffles the deck
    Collections.shuffle(this.cards);

    // Deals the hand
    for (int i = 0; i < numberOfCards; i++) {
      System.out.println(this.cards.get(i));
    }
  }

  /**
   * Retrieves the hand of cards that has been dealt.
   *
   * @return the hand of cards.
   */
  public static List<String> getHand() {
    // Returns the hand
    return cards.subList(0, 5);
  }

  /** Checks the properties of the current hand of cards. */
  public void checkHand() {
    List<String> hand = DeckOfCards.getHand();

    // Calculates the sum of the cards
    int sum = hand.stream().mapToInt(card -> getValue(card.substring(0, card.length() - 1))).sum();

    // Retrieves the cards of hearts
    String heartsCards =
        hand.stream().filter(card -> card.startsWith("H")).collect(Collectors.joining(", "));

    // Checks if the hand has the queen of spades
    boolean hasQueenOfSpades = hand.stream().anyMatch(card -> card.equals("SQ"));

    // Checks if the hand has a flush
    boolean hasFlush =
        hand.stream()
            .collect(
                Collectors.groupingBy(
                    card -> card.charAt(card.length() - 1), Collectors.counting()))
            .values()
            .stream()
            .anyMatch(count -> count == 5);

    // Prints the result
    String result =
        "Flush: "
            + hasFlush
            + "\nQueen of Spades: "
            + hasQueenOfSpades
            + "\nSum: "
            + sum
            + "\nHearts Count: "
            + heartsCards;
    System.out.println(result);
  }

  // Update GUI textfields

  /**
   * Retrieves the sum of the cards in the hand.
   *
   * @return the sum of the cards.
   */
  public int getSum() {
    List<String> hand = DeckOfCards.getHand();
    int sum = 0;
    for (String card : hand) {
      sum += getValue(card.substring(0, card.length() - 1));
    }
    return sum;
  }

  /**
   * Retrieves the cards of hearts in the hand.
   *
   * @return the cards of hearts.
   */
  public String getCardsOfHearts() {
    List<String> hand = DeckOfCards.getHand();
    List<String> heartsCards = new ArrayList<>();
    for (String cards : hand) {
      if (cards.startsWith("H")) {
        heartsCards.add(cards);
      }
    }
    if (heartsCards.isEmpty()) {
      return "No hearts";
    } else {
      return String.join(", ", heartsCards);
    }
  }

  /**
   * Checks if the hand has the queen of spades.
   *
   * @return "Yes" if the hand has the queen of spades, "No" otherwise.
   */
  public String hasQueenOfSpades() {
    List<String> hand = DeckOfCards.getHand();
    for (String card : hand) {
      if (card.equals("SQ")) {
        return "Yes";
      }
    }
    return "No";
  }

  /**
   * Checks if the hand has a flush.
   *
   * @return "Yes" if the hand has a flush, "No" otherwise.
   */
  public String hasFlush() {
    Map<Character, Integer> suitCount = new HashMap<>();
    List<String> hand = DeckOfCards.getHand();
    for (String card : hand) {
      char suit = card.charAt(card.length() - 1);
      suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
    }
    for (int count : suitCount.values()) {
      if (count == 5) {
        return "Yes";
      }
    }
    return "No";
  }

  // Private helper method to get the value of a card
  private int getValue(String rank) {
    // Converts the cardvalue to a numbervalue
    switch (rank) {
      case "1" -> {
        return 1;
      }
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
      case "11" -> {
        return 11;
      }
      case "12" -> {
        return 12;
      }
      case "13" -> {
        return 13;
      }
      default -> {
        return 0;
      }
    }
  }
}
