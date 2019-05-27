package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        GameObject tempObject = handler.object.get(0);

        //if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
        //if(key == KeyEvent.VK_S) tempObject.setVelY(5);
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
        if(key == KeyEvent.VK_ESCAPE) System.exit( 0);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        GameObject tempObject = handler.object.get(0);

        //if(key == KeyEvent.VK_W) tempObject.setVelY(0);
        //if(key == KeyEvent.VK_S) tempObject.setVelY(0);
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
    }

}
