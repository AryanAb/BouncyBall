package com.game.main;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends Canvas{

    public EditorWindow(int width, int height, String title, LevelEditor editor){

        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

         /*frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         frame.setUndecorated(true);*/

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(editor);
        frame.setVisible(true);
        editor.start();

    }

}
