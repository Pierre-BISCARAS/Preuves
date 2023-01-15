package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ZoneNombre extends HBox {
    private Integer nbr1;
    private Integer nbr2;

    public ZoneNombre() {

    TextField texte1 = new TextField();
    texte1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            nbr1 = Integer.parseInt(texte1.getText());

        }
        
    });

    TextField texte2 = new TextField();
    texte2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            nbr2 = Integer.parseInt(texte2.getText());

        }
        
    });

    this.getChildren().addAll(texte1,texte2);
    }
    public Integer getnbr1(){
        return this.nbr1;
    }
    public Integer getnbr2(){
        return this.nbr2;
    }

}
