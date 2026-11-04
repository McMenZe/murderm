package com.murderm.entities;

import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

// dient als Vorlage -> gibt bspweise Player, x und y koordinaten für Movement -> gleiche für andere die die Vorlage bekommen
public abstract class Entity {
    protected boolean hasCollision;
    public final int xyScale = 4;
    protected double x, y;
    public abstract void update(double dt, List<Entity> entities);
    public abstract void render(GraphicsContext gc);
    public abstract Rectangle2D getBounds();

    //
    public boolean collidesWith(Entity other) {
        return getBounds().intersects(other.getBounds());
    }

    // transparent entities
    public void onCollision(Entity other) { }

    //
    public boolean isSolide() {
        if (hasCollision) return true;
        return false;
    }

}
