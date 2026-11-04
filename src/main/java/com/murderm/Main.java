package com.murderm;
import com.murderm.input.InputHandler;
import com.murderm.ui.SceneHandler;

import javafx.application.Application;
import javafx.stage.Stage;

//

public class Main extends Application {

    String gameName = "Murder Mystery";

    @Override
    public void start(Stage stage) throws Exception {

        // SETUP - main Scene
        int width = 800;
        int height = 600;
        SceneHandler sceneHandler = new SceneHandler(width, height);

        // SETUP - Handle Scene Input
        InputHandler input = InputHandler.getInstance();
        input.enableInput();

        //
        stage.setTitle(gameName);
        stage.setScene(sceneHandler.getMainScene());
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}