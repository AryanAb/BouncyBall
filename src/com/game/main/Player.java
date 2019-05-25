package com.game.main;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Player extends GameObject {

    Handler handler;
    int heightTraveled = 0;
    boolean bouncing = false;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        setVelY(+3);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
    x += velX;
    y += velY;

    collision();
    if(bouncing) bounce();
    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Tile) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    bouncing = true;
                }
            }

        }
    }

    private void bounce() {

        setVelY(-3);
        heightTraveled += getVelY();
        System.out.println(heightTraveled);
        if(heightTraveled == -99){
            setVelY(+3);
            bouncing = false;
            heightTraveled = 0;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        //g.fillRect(x, y, 32, 32);
        g.fillOval(x, y, 32, 32);
    }
}
