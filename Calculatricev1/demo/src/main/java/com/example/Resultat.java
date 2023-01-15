package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Resultat extends HBox {
    
    public Resultat(float result) {

        TextField resultat = new TextField();
        System.out.print("test");

        resultat.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                String resultString = Float.toString(result);
                resultat.setText(resultString);
            }
            
        });

        this.getChildren().addAll(resultat);
    }

}