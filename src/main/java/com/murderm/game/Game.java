package com.murderm.game;

import java.util.ArrayList;
import java.util.List;

import com.murderm.entities.Entity;
import com.murderm.entities.Player;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

public class Game {
    private final Renderer renderer;
    private final AnimationTimer timer;
    private long last = 0;

    //
    private final List<Entity> entities = new ArrayList<>();

    //
    public Game(Canvas canvas) {

        Player plr = new Player("Dummy");
        addEntity(plr);

        Objects obj = new Objects("box.png");
        addEntity(obj);

        this.renderer = new Renderer(canvas);   // einmal erzeugen

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (last == 0) {
                    last = now;
                    return;
                }
                double dt = (now - last) / 1_000_000_000.0; // deltatime
                last = now;

                // Update
                update(dt, entities);

                // Render
                renderer.render(entities);

            }
        };

    }


    // Add Entities
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    // get Entities
    public List<Entity> getEntities() {
        return entities;
    }

    // on Update    
    private void update(double dt, List<Entity> entities) {
        for (Entity entity : entities) {
            entity.update(dt, entities);
        }
    }

    //
    public void start() {
        last = 0; timer.start();
    }

    public void stop() {
        timer.stop();
    }

}
