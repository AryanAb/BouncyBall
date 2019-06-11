package com.game.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VBoost extends GameObject {

    /**
     *
     * @param x
     * @param y
     * @param id
     */
    public VBoost(int x, int y, ID id){
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

        File path = new File("Assets/VerticalBooster.png");

        BufferedImage img = null;
        try {
            img = ImageIO.read(path);
        } catch (IOException e) {
            System.err.println(e);
        }

        g.drawImage(img, x, y, null);
    }
}
