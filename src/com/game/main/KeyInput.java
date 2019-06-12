package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private TextHandler tHandler = new TextHandler(null);
    private Window win;

    private int level = 1;

    public KeyInput(Handler handler, Window win) {
        this.handler = handler;
        this.win = win;
    }

    /**
     *
     * @param e
     */
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

        if (HUD.won) {
            HUD.showFirst = true;
            if(key == KeyEvent.VK_SPACE){
                while (handler.object.size() > 0) {
                    for(int i = 0; i < handler.object.size(); i++) {
                        System.out.println(handler.object.size());
                        GameObject temp = handler.object.get(i);
                        handler.removeObject(temp);
                    }
                }
                level++;
                tHandler.load(handler, level);
                HUD.showFirst = false;
                HUD.won = false;
            }
        }

        if(HUD.lost) {
            HUD.showFirst = true;
            if(key == KeyEvent.VK_SPACE){
                tHandler.load(handler, level);
            }
            HUD.lost = false;
            HUD.showFirst = false;
        }


    }

    /**
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        GameObject tempObject = handler.object.get(0);

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
    }

}
