package com.game.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends GameObject {

    private Handler handler;
    private int heightTraveled = 0;
    private boolean bouncing = false;
    private boolean vBoosting = false;
    private boolean hBoosting = false;

    public static boolean inputEnabled = true;
    public static boolean collisionRight = false;
    public static boolean collisionLeft = false;
    public static int velocityMultiplierRight = 1;
    public static int velocityMultiplierLeft = 1;


    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        setVelY(0);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 29, 29);
    }

    @Override
    public void tick() {
    x += velX;
    y += velY;

    collision();
    if(bouncing) bounce();
    if(vBoosting) vBoost();
    if(hBoosting) hBoost();

    if(this.y > 815 || this.y < 0){
        HUD.lost = true;
        inputEnabled = false;
    }

    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BounceTile) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (getY() + 26 > tempObject.getBounds().y - 5 && getY() + 26 < tempObject.getBounds().y + 5) {
                        bouncing = true;
                    } else {
                        velY = +3;
                        hBoosting = false;
                        vBoosting = false;
                        velX = 0;
                        inputEnabled = true;
                        if(tempObject.getX() > this.x){
                            velocityMultiplierRight = 0;
                        } else if(tempObject.getX() < this.x){
                            velocityMultiplierLeft = 0;

                        }
                    }
                } else{
                    //velocityMultiplierRight = 1;
                    //velocityMultiplierLeft = 1;
                }
            } else if (tempObject.getId() == ID.DeathTile) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //System.out.println("You died");
                    HUD.lost = true;
                    inputEnabled = false;
                }
            }
            if (tempObject.getId() == ID.Star) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.numStars--;
                    Star.playSound();
                    handler.removeObject(tempObject);
                }
            }
            if (tempObject.getId() == ID.VBoost) {
                // simplify the if statements
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (getY() + 26 > tempObject.getBounds().y - 5 && getY() + 26 < tempObject.getBounds().y + 5) {
                        vBoosting = true;
                    } else {
                        velX = 0;
                    }
                }
            }
            if (tempObject.getId() == ID.HBoost) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    hBoosting = true;
                    inputEnabled = false;
                    System.out.println("Test");
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
        velY = -4;
        vBoosting = false;
    }

    private void hBoost() {
        //HBoost h = new HBoost(0, 0, ID.HBoost);
        //setVelX(h.getDirection() * 4);
        velX = +4;
        velY = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 26, 26);

        //debugging
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.green);
        g2d.draw(getBounds());
    }
}
