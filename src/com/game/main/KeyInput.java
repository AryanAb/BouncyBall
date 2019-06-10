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

        if(Player.inputEnabled) {
            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                tempObject.setVelX(5 * Player.velocityMultiplierRight);
                Player.velocityMultiplierLeft = 1;
            }
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                tempObject.setVelX(-5 * Player.velocityMultiplierLeft);
                Player.velocityMultiplierRight = 1;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        GameObject tempObject = handler.object.get(0);

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
    }

}
