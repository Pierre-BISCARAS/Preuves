package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonSoustractionAddition extends HBox {
    private String operation = new String();
    public ButtonSoustractionAddition() {

        
        Button addition = new Button("+");
        addition.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                operation = "+";
            }
            
        });
        
        Button soustraction = new Button("-");

        soustraction.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
               operation = "-";
            }
            
        });

        Button diviser = new Button("/");
        diviser.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                operation = "/";
            }
            
        });
        Button multiplier = new Button("x");
        multiplier.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                operation = "*";
            }
            
        });
        this.getChildren().addAll(addition,soustraction,diviser,multiplier);
    }
    public String getOperation(){
        return this.operation;
    }
}