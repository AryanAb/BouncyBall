package com.game.main;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class Star extends GameObject {

    public Star(int x, int y, ID id){
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
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 25, 25);
    }
}
