package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonCalculerEffacer extends HBox {
    private float resultat;
    public ButtonCalculerEffacer(Integer nbr1,Integer nbr2, String operation) {

        Button ButtonCalculter = new Button("Calculer");
        ButtonCalculter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if (operation == "*") {
                    resultat = nbr1*nbr2;
                }
                else if(operation =="/" ) {
                    resultat = nbr1/nbr2;
                }
                else if(operation =="+" ) {
                    resultat = nbr1+nbr2;
                }
                else if(operation =="-" ) {
                    resultat = nbr1-nbr2;
                }  
            }
            
        });
        Button ButtonEffacer = new Button("Effacer");

        this.getChildren().addAll(ButtonCalculter,ButtonEffacer);
    }
    public float getResult() {
        return resultat;
    }

}