package com.toivoland.dictionary.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreen {

    public void createScreen(Stage primaryStage){
        Parent root = new BorderPane();

        VBox findingArea = FindingArea.getInstance().getFindingArea();

        ((BorderPane) root).setTop(new Toolbar().getToolbar());
        ((BorderPane) root).setLeft(SearchAddArea.getInstance().getSearchAddArea());
        ((BorderPane) root).setRight(findingArea);
        BorderPane.setMargin(findingArea , new Insets(0, 60, 0, 0));
        ((BorderPane) root).setCenter(new SearchAddButtonArea().getSearchAddButtonArea());

        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }
}
