package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A GUI for the DeckOfCards class.
 *
 * <p>The GUI has a button to deal a hand of cards, and a button to check the hand. The GUI also
 * displays the hand of cards, and the result of the check.</p>
 * <p>The GUI is created using JavaFX.</p>
 *
 */
public class DeckGUI extends Application {
  private TextField sumTextField;
  private TextField cardsOfHeartsTextField;
  private TextField flushTextField;
  private TextField queenOfSpadesTextField;
  private HBox infoBox;

  /**
   * The main method for the DeckGUI class.
   *
   * @param primaryStage The primary stage for the GUI.
   */
  @Override
  public void start(Stage primaryStage) {
    BorderPane root = createGUI();

    Scene scene = new Scene(root, 640, 480);
    primaryStage.setTitle("Deck of Cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Creates the main GUI for the DeckGUI class.
   *
   *
   * @return The main GUI for the DeckGUI class.
   */
  private BorderPane createGUI() {
    BorderPane rootNode = new BorderPane();

    // Center pane
    FlowPane centerPane = new FlowPane();
    centerPane.setAlignment(Pos.CENTER);
    centerPane.setPadding(new Insets(10));
    centerPane.setPrefWidth(100);
    VBox infoBox = new VBox(10);
    centerPane.getChildren().add(infoBox);

    VBox rightPane = createRightPane();

    GridPane bottomPane = createBottomPane();

    HBox centerContainer = createCenterContainer();

    rootNode.setCenter(centerPane);
    rootNode.setRight(rightPane);
    rootNode.setBottom(bottomPane);
    rootNode.setCenter(centerContainer);

    return rootNode;
  }

  /**
   * Creates the container for center alignment of card images
   *
   * @return the container for center alignment of card images
   */
  private HBox createCenterContainer() {
    HBox centerContainer = new HBox();
    centerContainer.setAlignment(Pos.CENTER);
    infoBox = new HBox(10);
    infoBox.setAlignment(Pos.CENTER);
    infoBox.setPadding(new Insets(100, 0, 100, 0));
    centerContainer.getChildren().add(infoBox);
    return centerContainer;
  }

  /**
   * Creates an ImageView for a card image.
   *
   * @param cardName The name of the card image.
   * @return The ImageView for the card image.
   */
  private ImageView createCardImageView(String cardName) {
    String imagePath = "/cards/" + cardName;
    Image cardImage = new Image(getClass().getResourceAsStream(imagePath));
    ImageView imageView = new ImageView(cardImage);

    imageView.setFitWidth(100);
    imageView.setPreserveRatio(true);
    return imageView;
  }

  /**
   * Creates the right pane with buttons for dealing and checking the hand.
   *
   * @return VBox with buttons for dealing and checking the hand.
   */

  private VBox createRightPane() {
    DeckOfCards deckOfCards = new DeckOfCards();
    VBox rightContainer = new VBox();
    rightContainer.setAlignment(Pos.CENTER_RIGHT);
    rightContainer.setSpacing(15);
    rightContainer.setPadding(new Insets(0, 20, 0, 0));
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(
        e -> {
          deckOfCards.dealHand(5);
          List<String> hand = DeckOfCards.getHand();
          infoBox.getChildren().clear();
          for (String card : hand) {
            ImageView imageView = createCardImageView(card + ".png");
            infoBox.getChildren().add(imageView);
          }
        });
    Button checkButton = new Button("Check hand");
    checkButton.setOnAction(
        e -> {
          deckOfCards.checkHand();
          sumTextField.setText(Integer.toString(deckOfCards.getSum()));
          cardsOfHeartsTextField.setText(String.join(", ", deckOfCards.getCardsOfHearts()));
          flushTextField.setText(deckOfCards.hasFlush());
          queenOfSpadesTextField.setText(deckOfCards.hasQueenOfSpades());
        });
    rightContainer.getChildren().addAll(dealButton, checkButton);
    return rightContainer;
  }

  /**
   * Creates the bottom pane with text fields for displaying the result of the check.
   *
   * @return GridPane with text fields for displaying the result of the check.
   */

  private GridPane createBottomPane() {
    GridPane bottomContainer = new GridPane();

    bottomContainer.setHgap(10);
    bottomContainer.setVgap(10);
    bottomContainer.setPrefHeight(100);
    bottomContainer.setPrefWidth(300);

    Text sumText = new Text("Sum of cards:");
    sumTextField = new TextField();
    sumTextField.setEditable(false);
    bottomContainer.add(sumText, 0, 0);
    bottomContainer.add(sumTextField, 1, 0);

    Text cardsOfHeartsText = new Text("Number of hearts:");
    cardsOfHeartsTextField = new TextField();
    cardsOfHeartsTextField.setEditable(false);
    bottomContainer.add(cardsOfHeartsText, 0, 1);
    bottomContainer.add(cardsOfHeartsTextField, 1, 1);

    Text flushText = new Text("Flush:");
    flushTextField = new TextField();
    flushTextField.setEditable(false);
    bottomContainer.add(flushText, 3, 0);
    bottomContainer.add(flushTextField, 4, 0);

    Text queenOfSpadesText = new Text("Queen of Spades:");
    queenOfSpadesTextField = new TextField();
    queenOfSpadesTextField.setEditable(false);
    bottomContainer.add(queenOfSpadesText, 3, 1);
    bottomContainer.add(queenOfSpadesTextField, 4, 1);

    return bottomContainer;
  }

  /**
   * Launch the GUI.
   *
   * @param args Command-line arguments supplied during startup
   */
  public static void appMain(String[] args)
  {
    launch(args);
  }
}
