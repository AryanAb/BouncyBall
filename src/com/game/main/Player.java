package com.game.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends GameObject {

    //Variables
    private Handler handler;
    private int heightTraveled = 0;
    private boolean bouncing = false;
    public static boolean inputEnabled = true;
    public static int velocityMultiplierRight = 1;
    public static int velocityMultiplierLeft = 1;


    /**
     *
     * @param x
     * @param y
     * @param id
     * @param handler
     */
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        setVelY(0);
    }

    /**
     *
     * @return
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 29, 29);
    }

    /**
     *
     */
    @Override
    public void tick() {
    x += velX;
    y += velY;

    collision();
    if(bouncing) bounce();

    if(this.y > 815 || this.y < 0){
        HUD.lost = true;
        inputEnabled = false;
    }

    }

    /**
     *
     */
    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BounceTile) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (getY() + 26 > tempObject.getBounds().y - 3 && getY() + 26 < tempObject.getBounds().y + 3) {
                        bouncing = true;
                    }
                    else {
                        velY = +3;
                        velX = 0;
                        inputEnabled = true;
                        bouncing = false;
                        if(tempObject.getX() > this.x){
                            velocityMultiplierRight = 0;
                            this.x -= 2;
                        } else if(tempObject.getX() < this.x){
                            velocityMultiplierLeft = 0;
                            this.x += 2;

                        }
                    }
                } else{
                    //velocityMultiplierRight = 1;
                    //velocityMultiplierLeft = 1;
                }
            } else if (tempObject.getId() == ID.DeathTile) {
                if (getBounds().intersects(tempObject.getBounds())) {
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
                if (getBounds().intersects(tempObject.getBounds())) {
                    this.y -= 1;
                    if (getY() + 26 > tempObject.getBounds().y - 3 && getY() + 26 < tempObject.getBounds().y + 3) {
                        vBoost();
                    } else {
                        velX = 0;
                    }
                }
            }
            if (tempObject.getId() == ID.HBoost) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //hBoosting = true;
                    hBoost(((HBoost) tempObject).direction);
                    inputEnabled = false;
                    System.out.println("Test");
                }
            }
        }
    }

    /**
     *
     */
    private void bounce() {

        setVelY(-3);
        heightTraveled += getVelY();
        if(heightTraveled == -99){
            setVelY(+3);
            bouncing = false;
            heightTraveled = 0;
        }
        velocityMultiplierLeft = 1;
        //velocityMultiplierRight = 1;

    }

    /**
     *
     */
    private void vBoost() {
        velY = -4;
    }

    /**
     *
     * @param direction
     */
    private void hBoost(int direction) {
        velX = +4 * direction;
        velY = 0;
    }

    /**
     *
     * @param g
     */
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
