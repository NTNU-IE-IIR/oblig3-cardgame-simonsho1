package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.CancellationException;

public class DeckGUI extends Application {
    private DeckOfCards deckOfCards;
    private VBox infoBox;
    private TextField sumTextField;
    private TextField cardsOfHeartsTextField;
    private TextField queenOfSpadesTextField;
    private TextField flushTextField;

  @Override
  public void start(Stage primaryStage) {
    this.deckOfCards = new DeckOfCards();

    BorderPane root = new BorderPane();
    FlowPane centerPane = createCenterPane();
    GridPane bottomGridPane = createBottomPane();
    root.setCenter(centerPane);
    root.setRight(createRightPane());
    root.setBottom(bottomGridPane);

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setTitle("Deck of cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private FlowPane createCenterPane() {
    FlowPane centerContainer = new FlowPane();
    centerContainer.setAlignment(Pos.CENTER);
    centerContainer.setPrefWidth(300);
    infoBox = new VBox(10);
    centerContainer.getChildren().add(infoBox);
    return centerContainer;
  }

  private VBox createRightPane() {
    VBox rightContainer = new VBox();
    rightContainer.setAlignment(Pos.CENTER_RIGHT);
    rightContainer.setSpacing(25);
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(actionEvent -> {
      deckOfCards.dealHand(5);
      addInfoText("Hand dealt");
    });
    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(actionEvent -> {
      deckOfCards.checkHand();
      addInfoText("Hand checked");
    });
    rightContainer.getChildren().addAll(dealButton, checkHandButton);
    return rightContainer;
  }

  private GridPane createBottomPane() {
    GridPane bottomContainer = new GridPane();
    bottomContainer.setAlignment(Pos.CENTER);
//    bottomContainer.setPadding(new Insets(10));
    bottomContainer.setHgap(10);
    bottomContainer.setVgap(10);

    sumTextField = new TextField();
    sumTextField.setEditable(false);
    bottomContainer.add(new Text("Sum of the Cards: "), 0, 0);
    bottomContainer.add(sumTextField, 1, 0);

    cardsOfHeartsTextField = new TextField();
    cardsOfHeartsTextField.setEditable(false);
    bottomContainer.add(new Text("Cards of Hearts: "), 0, 1);
    bottomContainer.add(cardsOfHeartsTextField, 1, 1);

    queenOfSpadesTextField = new TextField();
    queenOfSpadesTextField.setEditable(false);
    bottomContainer.add(new Text("Queen of Spades: "), 0, 2);
    bottomContainer.add(queenOfSpadesTextField, 1, 2);

    flushTextField = new TextField();
    flushTextField.setEditable(false);
    bottomContainer.add(new Text("Flush: "), 0, 3);
    bottomContainer.add(flushTextField, 1, 3);

    return bottomContainer;

  }

  private void addInfoText(String text) {
    infoBox.getChildren().add(new Button(text));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
