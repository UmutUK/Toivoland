package com.toivoland.dictionary.view;

import com.toivoland.dictionary.data.collection.DataCollectionAccessor;
import javafx.event.EventHandler;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.List;


public class SearchAddButtonArea {

    VBox searchAddButtonArea;

    SearchAddButtonArea(){

        searchAddButtonArea = new VBox();
        searchAddButtonArea.setPrefSize(80,400);
        searchAddButtonArea.setMaxHeight(450);
        searchAddButtonArea.setTranslateX(30);
        searchAddButtonArea.setTranslateY(7);
        searchAddButtonArea.setStyle("-fx-background-color: #1ab1cd");
        searchAddButtonArea.getChildren().addAll(getSearchButton(),getQuizButton(),getAddButton());
    }

    private Button getSearchButton(){
        Button search = new Button();
        search.setPrefSize(80, 40);
        search.setTranslateX(35);
        search.setTranslateY(65);
        search.setText("Search");
        search.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mousetEvent) {
                // TODO Auto-generated method stub
                System.out.println("Button clicked");

               String searchResult = DataCollectionAccessor.getInstance().getSearchResult(SearchAddArea.getInstance().getFirstLanguageText().getText().trim(),
                       FindingArea.getInstance().getSecondLanguageText().getText().trim(), SearchAddArea.getInstance().getSearchTextArea().getText().trim());

               if(0 < searchResult.length()) {

                   FindingArea.getInstance().getFindingTextArea().setText(searchResult);

               }else{
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Not Found");
                   alert.setContentText("The " + SearchAddArea.getInstance().getSearchTextArea().getText().trim() + "not found in the dictionary.");
                   alert.show();
               }
            }
        } );

        return search;
    }

    private Button getQuizButton(){
        Button quiz = new Button();
        quiz.setPrefSize(80, 40);
        quiz.setTranslateX(35);
        quiz.setTranslateY(140);
        quiz.setText("Quiz");
        return quiz;
    }

    private Button getAddButton(){
        Button addButton = new Button();
        addButton.setPrefSize(80, 40);
        addButton.setTranslateX(35);
        addButton.setTranslateY(220);
        addButton.setText("Add");
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent mouseEvent) {
                // TODO Auto-generated method stub
                System.out.println("Button clicked");

                DataCollectionAccessor.getInstance().addDataDictionary(SearchAddArea.getInstance().getFirstLanguageText().getText(), SearchAddArea.getInstance().getAddNewWordTextArea().getText().trim(),
                        SearchAddArea.getInstance().getAddExampleTextArea().getText().trim(), FindingArea.getInstance().getSecondLanguageText().getText(), FindingArea.getInstance().getAddNewWordTextArea().getText().trim(),
                        FindingArea.getInstance().getAddExampleTextArea().getText().trim());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("New word successfully added");
                alert.show();
                SearchAddArea.getInstance().getAddNewWordTextArea().setText("");
                SearchAddArea.getInstance().getAddExampleTextArea().setText("");

                FindingArea.getInstance().getAddNewWordTextArea().setText("");
                FindingArea.getInstance().getAddExampleTextArea().setText("");

            }
        } );
        return addButton;
    }

    public VBox getSearchAddButtonArea() {
        return searchAddButtonArea;
    }
}
