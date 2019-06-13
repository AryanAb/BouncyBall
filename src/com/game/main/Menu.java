/** Menu.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a menu
  */


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;

public class Menu extends MouseAdapter {

    //Variables
    private Game game;
    private Handler handler;
    private TextHandler tHandler;

    /**
     *
     * @param game
     * @param handler
     */
    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
        tHandler = new TextHandler(null);
    }

    /**Proceed to different sections of the game
     * @param e the position of mouse click
     * @return the game state according to the mouse position
     */
    public void mousePressed(MouseEvent e){

        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, 650, 120, 218, 113) && game.gameState == Game.STATE.Menu){

            tHandler.load(handler, 1);
            game.gameState = Game.STATE.Game;


        } else if(mouseOver(mx, my, 600, 280, 691, 114) && game.gameState == Game.STATE.Menu){

            game.gameState = Game.STATE.LevelEditor;


            new LevelEditor();

        }else if(mouseOver(mx, my, 555, 440, 410, 88) && game.gameState == Game.STATE.Menu){

            game.gameState = Game.STATE.Instructions;

        } else if(mouseOver(mx, my, 650, 570, 218, 114) && game.gameState == Game.STATE.Menu) {
            System.exit(0);
        } else if(mouseOver(mx, my, 650, 570, 200, 85) && game.gameState == Game.STATE.Instructions) {
            game.gameState = Game.STATE.Menu;
        }

    }


    /**
     *
     * @param mx
     * @param my
     * @param x
     * @param y
     * @param width
     * @param height
     * @return boolean
     */
    private boolean mouseOver(int mx, int my,  int x, int y, int width, int height){

        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }

    }

    public void tick(){

    }

    /**Render all the images that will be used to guide the user to go to different sections of the game
     * @param g graphics
     */
    public void render(Graphics g){

        if(game.gameState == Game.STATE.Menu) {
            BufferedImage play = null;
            try {
                play = ImageIO.read(new File("Assets/Play.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(play, 650, 120, null);

            BufferedImage levelEditor = null;
            try {
                levelEditor = ImageIO.read(new File("Assets/LevelEditor.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(levelEditor, 420, 280, null);

            BufferedImage instructions = null;
            try {
                instructions = ImageIO.read(new File("Assets/Instructions.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(instructions, 280, 125, null);

            BufferedImage quit = null;
            try {
                quit = ImageIO.read(new File("Assets/Quit.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(quit, 650, 570, null);

            Font font = new Font("arial", Font.BOLD, 50);

            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Menu", 680, 50);
        }
        if (game.gameState == Game.STATE.Instructions){
            Font font = new Font("arial", Font.BOLD, 30);

            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Press A or Left Arrow Key to move left, Press D or right Arrow Key to move right", 20, 100);
            g.drawString("Once level completed or you have lost, press space bar to try again. Also, press ESC to quit at any time", 20, 200);
            g.drawString("Make sure you dont step on the red death tile! Or else you will die", 20, 300);
            g.drawString("For level editor, press 1 for normal tile, press 2 for death tile, press 3 for star, press 4 for player", 20, 400);
            g.drawString("Press L for left horizontal booster, press R for right horizontal booster and press V for vertical booster", 20, 500);

            BufferedImage back = null;
            try {
                back = ImageIO.read(new File("Assets/Back.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(back, 650, 570, null);
        }

    }

}