package com.game.main;

import javax.swing.*;
import java.awt.*;
//import java.awt.Dimension;


public class Window extends Canvas {

    JFrame frame;

    public Window(int width, int height, String title, Game game){

        frame = new JFrame(title);

        //frame.setPreferredSize(new Dimension(width, height));
        //frame.setMaximumSize(new Dimension(width, height));
        //frame.setMinimumSize(new Dimension(width, height));

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }

    public void toggleVisibility(){

        frame.setVisible(false);
        frame.dispose();

    }

    /*public Dimension getPreferredSize( JComponent c) {
        Dimension size = ( (JToolBar.Separator)c ).getSeparatorSize();

        if( size != null) { return size.getSize(); }
        return null;

    }*/

}
