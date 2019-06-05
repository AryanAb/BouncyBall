// mouse input only

package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.StandardOpenOption;

public class EditorInput extends MouseAdapter {

    private LevelEditor editor;
    private EditorHandler eHandler;
    private Handler handler;

    public boolean BounceTileSelected = true;
    public boolean DeathTileSelected = false;
    public boolean StarSelected = false;
    public boolean PlayerSpawnSelected = false;

    public EditorInput(LevelEditor editor, EditorHandler eHandler, Handler handler){
        this.editor = editor;
        this.eHandler = eHandler;
        this.handler = handler;
    }

    public int gridFloor(int a){
        return a - (a % 75);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        Graphics g = null;

        if(BounceTileSelected) {
            eHandler.addObject(new Tile(gridFloor(mx), gridFloor(my), ID.BounceTile));
        } else if(DeathTileSelected) {
            eHandler.addObject(new DeathTile(gridFloor(mx), gridFloor(my), ID.DeathTile));
        } else if(StarSelected) {
            eHandler.addObject(new Star(gridFloor(mx) + 25, gridFloor(my) + 30, ID.Star));
        } else if(PlayerSpawnSelected) {
            eHandler.addObject(new Player(gridFloor(mx) + 20, gridFloor(my) + 10, ID.Player, handler));
        }

    }

}
