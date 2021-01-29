package com.toivoland.dictionary.view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Toolbar {

    private HBox toolbar;

    private static final String ENGLISH = "English";
    private static final String GERMAN = "Deutch";
    private static final String RUSSIAN = "Russian";
    private static final String TURKISH = "Turkish";


    Toolbar(){
        toolbar = new HBox();
        toolbar.setMaxWidth(590);
        toolbar.setPrefHeight(35);
        toolbar.setSpacing(50);
        toolbar.setTranslateX(10);
        toolbar.setTranslateY(10);
        toolbar.setStyle("-fx-background-color: #1ab1cd");
        toolbar.getChildren().addAll(getEnglishButton(), getDeutchButton(), getRussianButton());
    }
    private Button getEnglishButton(){
        Button english = new Button();
        english.setPrefSize(100, 20);
        english.setTranslateX(10);
        english.setTranslateY(5);
        english.setText(ENGLISH);
        english.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                // TODO Auto-generated method stub
                System.out.println("Button clicked");
                if (mouseEvent.getClickCount()%2 == 0 ) {
                    SearchAddArea.getInstance().setFirstLanguageText(TURKISH);
                    FindingArea.getInstance().setSecondLanguageText(ENGLISH);
                }else {
                    SearchAddArea.getInstance().setFirstLanguageText(ENGLISH);
                    FindingArea.getInstance().setSecondLanguageText(TURKISH);
                }
            }
        } );
        return english;
    }

    private Button getDeutchButton(){

        Button deutsch = new Button();
        deutsch.setPrefSize(100, 20);
        deutsch.setTranslateX(10);
        deutsch.setTranslateY(5);
        deutsch.setText(GERMAN);

        deutsch.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                // TODO Auto-generated method stub
                System.out.println("Button clicked");
                if (mouseEvent.getClickCount()%2 == 0 ) {
                    SearchAddArea.getInstance().setFirstLanguageText(TURKISH);
                    FindingArea.getInstance().setSecondLanguageText(GERMAN);
                }else {
                    SearchAddArea.getInstance().setFirstLanguageText(GERMAN);
                    FindingArea.getInstance().setSecondLanguageText(TURKISH);
                }
            }
        } );
        return deutsch;
    }

    private Button getRussianButton(){
        Button russian = new Button();
        russian.setPrefSize(100, 20);
        russian.setTranslateX(10);
        russian.setTranslateY(5);
        russian.setText(RUSSIAN);
        russian.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                // TODO Auto-generated method stub
                System.out.println("Button clicked");
                if (mouseEvent.getClickCount()%2 == 0 ) {
                    SearchAddArea.getInstance().setFirstLanguageText(TURKISH);
                    FindingArea.getInstance().setSecondLanguageText(RUSSIAN);
                }else {
                    SearchAddArea.getInstance().setFirstLanguageText(RUSSIAN);
                    FindingArea.getInstance().setSecondLanguageText(TURKISH);
                }
            }
        } );
        return  russian;
    }

    protected HBox getToolbar(){
        return toolbar;
    }
}
