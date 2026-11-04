package com.murderm.input;

import java.util.HashSet;
import java.util.Set;

import com.murderm.ui.SceneHandler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {
    private final Set<KeyCode> keys = new HashSet<>();
    private boolean isInputEnabled = false;

    // Singleton
    private static InputHandler instance = new InputHandler();
    public static InputHandler getInstance() {
        return instance;
    }

    // Event for the mainScene
    public void attachTo(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> keys.add(e.getCode()));         // e = event
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> keys.remove(e.getCode()));
    }

    public boolean isDown(KeyCode code) {
        return keys.contains(code);
    }

    //
    public void enableInput() {
        attachTo(SceneHandler.getInstance().getMainScene());
    }

    // getter
    public boolean isInputEnabled() {
        return isInputEnabled;
    }

}
