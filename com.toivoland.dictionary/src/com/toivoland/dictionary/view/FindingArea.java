package com.toivoland.dictionary.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FindingArea {

    private VBox findingArea;
    TextArea findingTextArea, addNewWordTextArea, addExampleTextArea;
    Text secondLanguageText;


    private static FindingArea instance = new FindingArea();

    public static FindingArea getInstance(){
        return  instance;
    }

    private FindingArea(){
        findingArea = new VBox();
        findingArea.setPrefSize(200,400);
        findingArea.setMaxHeight(450);
        findingArea.setTranslateX(50);
        findingArea.setTranslateY(20);
        findingArea.setStyle("-fx-background-color: #1ab1cd");
        setLanguageText();
        setSearchTextArea();
        setAddNewWordTextArea();
        setAddExampleTextArea();
        findingArea.getChildren().addAll(secondLanguageText, findingTextArea, addNewWordTextArea, addExampleTextArea);
    }

    private void setLanguageText(){
        secondLanguageText = new Text();
        secondLanguageText.setText("Turkish");
        secondLanguageText.setTranslateY(10);
        secondLanguageText.setTranslateX(80);
    }

    private void setSearchTextArea(){
        findingTextArea = new TextArea();
        findingTextArea.setMaxSize(160,140);
        findingTextArea.setText("Search value will be returned");
        findingTextArea.setTranslateY(30);
        findingTextArea.setTranslateX(20);
        findingTextArea.editableProperty().setValue(false);
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

    protected VBox getFindingArea(){
        return findingArea;
    }

    protected void setSecondLanguageText(String languageName){
        secondLanguageText.setText(languageName);
    }

    public Text getSecondLanguageText() {
        return secondLanguageText;
    }

    public TextArea getFindingTextArea() {
        return findingTextArea;
    }

    public TextArea getAddExampleTextArea() {
        return addExampleTextArea;
    }

    public TextArea getAddNewWordTextArea() {
        return addNewWordTextArea;
    }
}
