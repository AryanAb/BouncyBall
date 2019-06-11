package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class Menu extends MouseAdapter {

    //Variables
    private Game game;
    private Handler handler;
    private LevelEditor editor;
    private Player player;
    private TextHandler tHandler;
    private HUD hud;

    /**
     *
     * @param game
     * @param handler
     * @param hud
     */
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        tHandler = new TextHandler(null);
    }

    /**
     *
     * @param e
     */
    public void mousePressed(MouseEvent e){

        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, 650, 300, 200, 75) && game.gameState == Game.STATE.Menu){

            tHandler.load(handler);
            game.gameState = Game.STATE.Game;

            /*player = new Player(400, 200, ID.Player, handler);
            handler.addObject(player);
            player.velY = +3;
            handler.addObject(new Tile(100, 800, ID.BounceTile));
            handler.addObject(new Tile(175, 800, ID.BounceTile));
            //handler.addObject(new DeathTile(300,300, ID.DeathTile));
            handler.addObject(new HBoost(300, 400, ID.HBoost));
            handler.addObject(new Tile(100, 400, ID.BounceTile));
            handler.addObject(new Tile(200, 500, ID.BounceTile));
            handler.addObject(new Star(150, 725, ID.Star));
            handler.addObject(new Tile(250, 725, ID.BounceTile));
            handler.addObject(new Tile(550, 725, ID.BounceTile));
            handler.addObject(new Tile(625, 725, ID.BounceTile));
            handler.addObject(new Tile(700, 650, ID.BounceTile));
            handler.addObject(new Tile(775, 575, ID.BounceTile));
            handler.addObject(new Tile(850, 500, ID.BounceTile));
            handler.addObject(new Tile(925, 425, ID.BounceTile));
            handler.addObject(new Tile(1000, 350, ID.BounceTile));
            handler.addObject(new Tile(1075, 275, ID.BounceTile));
            handler.addObject(new Star(1100, 230, ID.Star));*/

        } else if(mouseOver(mx, my, 600, 400, 350, 75) && game.gameState == Game.STATE.Menu){

            game.gameState = Game.STATE.LevelEditor;

            //editor.main(new String[0]);
            //window.toggleVisibility();
            new LevelEditor();

        } else if(mouseOver(mx, my, 650, 500, 200, 75) && game.gameState == Game.STATE.Menu) {
            System.exit(0);
        }

    }

    /**
    public void mouseReleased(MouseEvent e){

    }
     */

    /**
     *
     * @param mx
     * @param my
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
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

    /**
     *
     * @param g
     */
    public void render(Graphics g){

        Font  font = new Font("arial", Font.BOLD, 50);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Menu", 680, 50);

        g.setFont(font);
        g.drawRect(650, 300, 200, 75);
        g.drawString("Play", 680, 350);

        g.drawRect(600, 400, 350, 75);
        g.drawString("Level Editor", 620, 450);

        g.drawRect(650, 500, 200, 75);
        g.drawString("Quit", 680, 550);
    }

}
