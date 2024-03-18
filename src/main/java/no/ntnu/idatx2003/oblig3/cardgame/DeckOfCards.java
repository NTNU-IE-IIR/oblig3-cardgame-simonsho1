package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.*;
import java.util.stream.Collectors;

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
    List<String> hand = DeckOfCards.getHand();

    int sum = hand.stream()
        .mapToInt(card -> getValue(card.substring(0, card.length() - 1)))
        .sum();

    String heartsCards = hand.stream()
        .filter(card -> card.startsWith("H"))
        .collect(Collectors.joining(", "));

    boolean hasQueenOfSpades = hand.stream()
        .anyMatch(card -> card.equals("SQ"));

    boolean hasFlush = hand.stream()
        .collect(Collectors.groupingBy(card -> card.charAt(card.length() - 1), Collectors.counting()))
        .values()
        .stream()
        .anyMatch(count -> count == 5);

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

  // Update GUI text fields
public int getSum() {
    List<String> hand = DeckOfCards.getHand();
    int sum = 0;
    for (String card : hand) {
      sum += getValue(card.substring(0, card.length() - 1));
    }
    return sum;
  }

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


    public String hasQueenOfSpades() {
    List<String> hand = DeckOfCards.getHand();
    for (String card : hand) {
      if (card.equals("SQ")) {
        return "Yes";
      }
    }
    return "No";
    }

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
