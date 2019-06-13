/**KeyInput.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create keyboard controls that are going to be used to play the game
  */

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

        if(handler.object.size() > 0) {
            GameObject tempObject = handler.object.get(0);


            if (Player.inputEnabled) {
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(5 * Player.velocityMultiplierRight);
                    Player.velocityMultiplierRight = 1;
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-5 * Player.velocityMultiplierLeft);
                    Player.velocityMultiplierLeft = 1;
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (HUD.won) {
            if(key == KeyEvent.VK_SPACE){
                while (handler.object.size() > 0) {
                    handler.object.removeFirst();
                }
                level++;
                tHandler.load(handler, level);
                HUD.won = false;
            }
        }

        if(HUD.lost) {
            if(key == KeyEvent.VK_SPACE){
                while (handler.object.size() > 0) {
                    handler.object.removeFirst();
                }
                HUD.numStars = 0;
                tHandler.load(handler, level);
                HUD.lost = false;
                Player.inputEnabled = true;
            }
        }


    }

    /**
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        GameObject tempObject = handler.object.get(0);
        if(Player.inputEnabled) {
            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                tempObject.setVelX(0);
            }
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                tempObject.setVelX(0);
            }
        }
    }

}