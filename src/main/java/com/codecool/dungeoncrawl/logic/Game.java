package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.ui.UI;
import com.codecool.dungeoncrawl.ui.keyeventhandler.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.Set;

public class Game extends Application {
    private UI ui;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;
    private GameLoop gameLoop;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.keyHandlers = Set.of(new Up(), new Down(), new Left(), new Right(), new Fight(), new Interact());
        this.logic = new GameLogic();

        this.ui = new UI(logic, keyHandlers);
        ui.setUpPain(primaryStage);


        int FPS = 1;
        gameLoop = new GameLoop(logic, ui, FPS);
        gameLoop.start();

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();

        /*
        Stop gameLoop thread too when closed
        https://www.tabnine.com/code/java/methods/javafx.stage.Stage/setOnCloseRequest
        */
        primaryStage.setOnCloseRequest(event -> {
            gameLoop.stop();
            Platform.exit();
            System.exit(0);
        });
    }
}
