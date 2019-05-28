package com.game.main;

import java.awt.*;

public class VBoost extends GameObject {

    public VBoost(int x, int y, ID id){
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
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 75, 75);
    }
}
