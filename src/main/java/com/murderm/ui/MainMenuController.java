package com.murderm.ui;

import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void onStartClick() {
        SceneHandler.getInstance().showGame();
    }

}