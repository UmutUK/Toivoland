package com.toivoland.dictionary.main;

import com.toivoland.dictionary.data.collection.DataCollectionAccessor;
import com.toivoland.dictionary.view.MainScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        DataCollectionAccessor.getInstance().load();
        launch(args);
        DataCollectionAccessor.getInstance().insert();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
       new MainScreen().createScreen(primaryStage);
    }
}
