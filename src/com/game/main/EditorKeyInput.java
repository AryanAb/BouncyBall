package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyInput extends KeyAdapter {

    private EditorInput eInput;
    private TextHandler tHandler;
    private EditorHandler eHandler;

    public EditorKeyInput(EditorInput eInput, EditorHandler eHandler) {
        this.eInput = eInput;
        this.eHandler = eHandler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_S) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)){
            tHandler = new TextHandler(eHandler);

            tHandler.save();

        }

        if(key == KeyEvent.VK_1){
            eInput.BounceTileSelected = true;
            eInput.DeathTileSelected = false;
            eInput.StarSelected = false;
        } else if(key == KeyEvent.VK_2){
            eInput.DeathTileSelected = true;
            eInput.BounceTileSelected = false;
            eInput.StarSelected = false;
        } else if(key == KeyEvent.VK_3){
            eInput.StarSelected = true;
            eInput.DeathTileSelected = false;
            eInput.BounceTileSelected = false;
        } else if(key == KeyEvent.VK_4){
            eInput.BounceTileSelected = false;
            eInput.DeathTileSelected = false;
            eInput.StarSelected = false;
            eInput.PlayerSpawnSelected = true;
        }

    }

}
