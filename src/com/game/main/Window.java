/**Window.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a frame to run the game later
  */

import javax.swing.*;
import java.awt.*;


public class Window extends Canvas {

    JFrame frame;

    /** Create a window/frame to open to run the game
     * @param width width of the frame
     * @param height height of the frame
     * @param title title of the frame
     * @param game the main game that is going to run on the frame
     */
    public Window(int width, int height, String title, Game game) {

        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }

    /**
     *
     */
    public void toggleVisibility() {

        frame.setVisible(false);
        frame.dispose();

    }


}