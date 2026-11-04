package com.murderm.entities;

import com.murderm.util.Assets;
import com.murderm.input.InputHandler;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.geometry.Rectangle2D;

public class Player extends Entity {
    private String name;
    private Image plrSprite;

    private int health = 100;
    private double vx, vy;
    private double speed = 250.0;
    private double smoothing = 10.0;

    private final InputHandler input = InputHandler.getInstance();

    // Constructor
    public Player(String name) {
        this.name = name;
        hasCollision = true;
        plrSprite = Assets.get("yellow-cat.png");
    }

    // State
    private void isDead() {
        if (this.health <= 0) {
            System.out.println(name + " Died");
            // change scene root to a new Canvas -> gameLostRoot oder so
        }
        return;
    }

    // Funcs
    public void takeDmg(int amount) {
        this.health -= amount;
        isDead();
    }

    // Called every Frame by AnimationTimer in Game.Java --- Every Entity has this!

    //
    private double lerp(double a, double b, double t) {
        return a + (b-a) * t;
    }

    @Override
    public void update(double dt, List<Entity> entities) {

        double dx = 0;
        double dy = 0;

        if (input.isDown(KeyCode.D)) { dx += speed * dt; }
        if (input.isDown(KeyCode.A)) { dx -= speed * dt; }
        if (input.isDown(KeyCode.W)) { dy -= speed * dt; }
        if (input.isDown(KeyCode.S)) { dy += speed * dt; }

        // Calculate Direction x, y
        double len = Math.hypot(dx, dy);
        if (len > 0) { dx /= len; dy /= len; }

        double targetVx = dx * speed;
        double targetVy = dy * speed;

        double t = 1 - Math.exp(-smoothing * dt);   // e^-10*dt

        vx = lerp(vx, targetVx, t);
        vy = lerp(vy, targetVy, t);

        // Check if Wall, Collision -> with geBounds of each Sprite ~ extended with Entity
        // Check CollisinHandler if is Collision

        x += vx * dt;
        for (Entity entity : entities) {
            if (entity != this && entity.isSolide() && collidesWith(entity)) {
                x -= vx * dt;
                vx = 0;
            }
        }

        y += vy * dt;
        for (Entity entity : entities) {
            if (entity != this && entity.isSolide() && collidesWith(entity)) {
                y -= vy * dt;
                vy = 0;
            }
        }

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(plrSprite, Math.round(x), Math.round(y), plrSprite.getWidth() * 4, plrSprite.getHeight() * 4);
    }

    @Override
    public Rectangle2D getBounds() {
        double width = plrSprite.getWidth();
        double height = plrSprite.getHeight();
        return new Rectangle2D(x-width, y-height, width * xyScale, height * xyScale);
    }

}
