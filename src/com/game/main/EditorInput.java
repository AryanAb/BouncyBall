// mouse input only

package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorInput extends MouseAdapter {

    private LevelEditor editor;
    private EditorHandler eHandler;

    public EditorInput(LevelEditor editor, EditorHandler eHandler){
        this.editor = editor;
        this.eHandler = eHandler;
    }

    public int gridFloor(int a){
        return a - (a % 75);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        System.out.println("Mouse pressed at: " + mx + " " + my);

        eHandler.addObject(new Tile(gridFloor(mx), gridFloor(my), ID.BounceTile));

    }

}
