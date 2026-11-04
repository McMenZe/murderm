package com.murderm.ui;

import com.murderm.Main;
import com.murderm.game.Game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class SceneHandler {
    private final Scene scene;
    private Parent menuRoot;
//    private Parent gameRoot;

    // Singleton -> macht den ganzen script Statisch, sodass er nur einmal hergestellt werden kann -> kann aber von allen script benutzt werden <3
    //              man holt sich SceneHandler mit der Funktion und instance returned sie

    private static SceneHandler instance;
    public static SceneHandler getInstance() {
        return instance;
    }

    // Constructor
    public SceneHandler(int width, int height) throws Exception {
        instance = this;

        // Main Menu
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/main-menu-view.fxml"));
        menuRoot = loader.load();
        //MainMenuController mainMenuController = loader.getController();

        // Create MainScene
        scene = new Scene(menuRoot, width, height);
        scene.setRoot(menuRoot);

    }

    // Create individual Fxml for scene States // SceneBuilder

    // show Canvas/ Roots
    public void showMenu() {
        scene.setRoot(menuRoot);
    }

    public void showGame() {

        // create gameRoot
        int width = 800;
        int height = 600;
        Canvas canvas = new Canvas(width, height);
        StackPane root = new StackPane(canvas);

        // set
//        gameRoot = root;

        // set Root -> Start game if not already started?
        Game game = new Game(canvas);
        scene.setRoot(root);
        game.start();

        // Damit der Input auf der neuen Canva aufgenommen werden kann
        canvas.requestFocus();

    }

    // getter
    public Scene getMainScene() {
        return scene;
    }

}
