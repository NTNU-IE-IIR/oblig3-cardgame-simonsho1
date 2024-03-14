package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeckGUI extends Application {
  private DeckOfCards deckOfCards;
  private VBox infoBox;

  @Override
  public void start(Stage primaryStage) {
    deckOfCards = new DeckOfCards();

    BorderPane root = new BorderPane();
    root.setCenter(createCenterPane());
    root.setRight(createRightPane());

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setTitle("Deck of cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private FlowPane createCenterPane() {
    FlowPane centerPane = new FlowPane();
    centerPane.setAlignment(Pos.CENTER);
    centerPane.setPrefWidth(300);
    infoBox = new VBox(10);
    centerPane.getChildren().add(infoBox);
    return centerPane;
  }

  private VBox createRightPane() {
    VBox rightPane = new VBox(10);
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(actionEvent -> DeckOfCards.dealHand(5));
    Button checkHandButton = new Button("Check hand");
    //checkHandButton.setOnAction(actionEvent -> checkHand());
    rightPane.getChildren().addAll(dealButton, checkHandButton);
    return rightPane;
  }

  private void addInfoText(String text) {
    infoBox.getChildren().add(new Button(text));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
