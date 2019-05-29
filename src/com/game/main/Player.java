package com.game.main;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Player extends GameObject {

    Handler handler;
    int heightTraveled = 0;
    boolean bouncing = false;
    boolean vBoosting = false;
    boolean hBoosting = false;
    HUD hud = new HUD();

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
    if(vBoosting) vBoost();
    if(hBoosting) hBoost();
    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BounceTile) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if (getY() + 32 > tempObject.getBounds().y - 5 && getY() + 32 < tempObject.getBounds().y + 5){
                        bouncing = true;
                    } else {
                        velX = 0;
                        velY = +3;
                    }
                }
            } else if(tempObject.getId() == ID.DeathTile) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    System.out.println("You died");
                }
            }
            if(tempObject.getId() == ID.Star) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                }
            }
            if(tempObject.getId() == ID.VBoost){
                // simplify the if statements
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(getY() + 32 > tempObject.getBounds().y - 5 && getY() + 32 < tempObject.getBounds().y + 5){
                        vBoosting = true;
                    } else {
                        velX = 0;
                    }
                }
            }
            if(tempObject.getId() == ID.HBoost){
                if(getBounds().intersects(tempObject.getBounds())) {
                    hBoosting = true;
                }
            }
        }
    }

    private void bounce() {

        setVelY(-3);
        heightTraveled += getVelY();
        if(heightTraveled == -99){
            setVelY(+3);
            bouncing = false;
            heightTraveled = 0;
        }

    }

    private void vBoost() {
        //setVelY(-4);
        velX = -4;
        vBoosting = false;
    }

    private void hBoost() {
        //HBoost h = new HBoost(0, 0, ID.HBoost);
        //setVelX(h.getDirection() * 4);
        velX = +4;
        velY = 0;
        hBoosting = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 32, 32);
    }
}
