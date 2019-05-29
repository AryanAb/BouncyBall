package com.game.main;

import java.awt.*;

public class HBoost extends GameObject {

    private int direction = 1;

    public HBoost(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 75, 75);
    }

    public void setDirection(int direction) {
        // depending on the rotation of the image set direction to 1 or -1
    }

    public int getDirection() {
        return direction;
    }
}
