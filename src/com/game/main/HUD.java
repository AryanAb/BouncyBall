package com.game.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HUD {

    private int score = 0;
    public static boolean lost = false;
    public static boolean won = false;
    public static int numStars;
    public static boolean showFirst = true;

    private long time;
    private static long startingTime;


    /**
     *
     */

    public static void startingTime(){
        startingTime =  System.currentTimeMillis();
    }

    public void tick() {
        if(numStars == 0){
            won = true;
        }
        long passedTime = System.currentTimeMillis() - startingTime;
        long seconds = passedTime / 1000;
        //System.out.println(seconds);
        time = 60 - seconds;
        if(time == 0){
            lost = true;
        }
    }

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Time Left: " + time, 10, 18);
        g.drawString("Stars Left: " + numStars, 10, 38);

        if(lost){
            File path = new File("Assets/GameOver.png");

            BufferedImage img = null;
            try {
                img = ImageIO.read(path);
            } catch (IOException e) {
                System.err.println(e);
            }
                g.drawImage(img, 250, 300, null);
        } else if(won){
            File path = new File("Assets/LevelCompleted.png");

            BufferedImage img = null;
            try {
                img = ImageIO.read(path);
            } catch (IOException e) {
                System.err.println(e);
            }
                g.drawImage(img, 250, 300, null);
        }
    }
}
