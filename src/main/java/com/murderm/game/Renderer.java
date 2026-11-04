package com.murderm.game;

import java.util.List;

import com.murderm.entities.Entity;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Renderer {
    private final GraphicsContext gc;
    private final double width, height;

    public Renderer(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();
        gc.setImageSmoothing(false);
    }

    // Entities also count as Walls, ...
    public void render(List<Entity> entities) {

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        for (Entity entity : entities) {
            entity.render(gc);
        }
    }

}
