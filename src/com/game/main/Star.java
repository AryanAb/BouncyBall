package com.game.main;

import org.w3c.dom.css.Rect;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

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

    public void playSound(){
        try {
            File file = new File("C:/Users/aryan/IdeaProjects/BouncyBall/Assets/smw_coin.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 25, 25);
    }
}
