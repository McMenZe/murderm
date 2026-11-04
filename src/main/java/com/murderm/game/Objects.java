package com.murderm.game;

import com.murderm.entities.Entity;
import com.murderm.util.Assets;

import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Objects extends Entity {
    private Image sprite;

    // Get Everything in Scene/ Root, create them -> give them collision, ...

    ////// BESTIMMTE OBJCETE BRAUCHEN EINE BESTIMMTE HITBOX, für kleinere Objecte
    /// DAMIT SOLLTE DANN AUCH KLICK OPTIONEN FUNKTIONIEREN WENN DIE HItbox angepasst ist
    /// 

    public Objects(String objPath) {
        sprite = Assets.get(objPath);
        x = 100;
        y = 100;

        // Set Collison diffrently
        hasCollision = false;
        // Add them to the CollisionManager -> she then works with the Game
    }

    // on Update
    @Override
    public void update(double dt, List<Entity> entities) {
        // update if it is a sprite sheet
    }

    @Override 
    public void render(GraphicsContext gc) {
        gc.drawImage(sprite, Math.round(x), Math.round(y), sprite.getWidth() * xyScale, sprite.getHeight() * xyScale);
    }

    // Get Bounds for Collision Detection
    @Override
    public Rectangle2D getBounds() {
        double width = sprite.getWidth();
        double height = sprite.getHeight();
        return new Rectangle2D(x-width, y-height, width * xyScale, height * xyScale);
    }

}
