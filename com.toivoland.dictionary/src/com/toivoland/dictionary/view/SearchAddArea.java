package com.toivoland.dictionary.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SearchAddArea {

    private VBox searchAddArea;
    private TextArea searchTextArea, addNewWordTextArea, addExampleTextArea;
    private Text firstLanguageText;

    private static SearchAddArea instance = new SearchAddArea();

    public static SearchAddArea getInstance(){
        return  instance;
    }

    private SearchAddArea(){
        searchAddArea = new VBox();
        searchAddArea.setPrefSize(200,400);
        searchAddArea.setMaxHeight(450);
        searchAddArea.setTranslateX(10);
        searchAddArea.setTranslateY(20);
        searchAddArea.setStyle("-fx-background-color: #1ab1cd");
        setLanguageText();
        setSearchTextArea();
        setAddNewWordTextArea();
        setAddExampleTextArea();
        searchAddArea.getChildren().addAll(firstLanguageText, searchTextArea, addNewWordTextArea, addExampleTextArea);
    }

    private void setLanguageText(){
        firstLanguageText = new Text();
        firstLanguageText.setText("English");
        firstLanguageText.setTranslateY(10);
        firstLanguageText.setTranslateX(80);
    }

    private void setSearchTextArea(){
        searchTextArea = new TextArea();
        searchTextArea.setMaxSize(160,140);
        searchTextArea.setText("null");
        searchTextArea.setTranslateY(30);
        searchTextArea.setTranslateX(20);
    }

    private void setAddNewWordTextArea() {
        addNewWordTextArea = new TextArea();
        addNewWordTextArea.setMaxSize(160, 80);
        addNewWordTextArea.setText("null");
        addNewWordTextArea.setTranslateY(80);
        addNewWordTextArea.setTranslateX(20);
    }

    private void setAddExampleTextArea() {
        addExampleTextArea = new TextArea();
        addExampleTextArea.setMaxSize(160, 80);
        addExampleTextArea.setText("null");
        addExampleTextArea.setTranslateY(100);
        addExampleTextArea.setTranslateX(20);
    }

    protected VBox getSearchAddArea(){
        return searchAddArea;
    }


    protected void setFirstLanguageText(String languageName){
        firstLanguageText.setText(languageName);
    }

    public Text getFirstLanguageText(){
        return firstLanguageText;
    }

    public TextArea getSearchTextArea() {
        return searchTextArea;
    }

    public TextArea getAddNewWordTextArea() {
        return addNewWordTextArea;
    }

    public TextArea getAddExampleTextArea() {
        return addExampleTextArea;
    }
}
