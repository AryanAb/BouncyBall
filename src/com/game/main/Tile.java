package com.game.main;

import java.awt.*;

public class Tile extends GameObject {

    /**
     *
     * @param x
     * @param y
     * @param id
     */
    public Tile(int x, int y, ID id){
        super(x, y, id);
    }

    /**
     *
     * @return
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    /**
     *
     */
    @Override
    public void tick() {

    }

    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 50, 50);
    }
}
