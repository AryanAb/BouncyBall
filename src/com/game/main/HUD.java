package com.game.main;

import java.awt.*;

public class HUD {

    private int score = 0;

    public boolean collided = false;

    /*public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }*/
    public void setCollided(boolean collided) {
        System.out.println("Set to true");
        this.collided = collided;
    }

    public void tick() {
        //System.out.println(collided);
        if(collided){
            System.out.println("You got the score!");
            score++;
            collided = false;
        }
    }

    public void addScore() {
        //score++;
        //collided = false;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 18);
    }

}
