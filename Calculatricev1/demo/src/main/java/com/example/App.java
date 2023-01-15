package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
      VBox vBox = new VBox();
      ButtonSoustractionAddition b = new ButtonSoustractionAddition();
      ZoneNombre c = new ZoneNombre();
      ButtonCalculerEffacer d = new ButtonCalculerEffacer(c.getnbr1(),c.getnbr2(), b.getOperation());
      Resultat f = new Resultat(d.getResult());

      vBox.getChildren().add(b);
      vBox.getChildren().add(c);
      vBox.getChildren().add(d);
      vBox.getChildren().add(f);

      Scene scene = new Scene(new StackPane(vBox), 305, 260);

      stage.setScene(scene);
      stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}