/** EditorWindow.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create the frame for the Level Editor
  */
import javax.swing.*;
import java.awt.*;

public class EditorWindow extends Canvas{
  
   /** Create a window/frame to open to run the game
     * @param width width of the frame
     * @param height height of the frame
     * @param title title of the frame
     * @param editor the level editor that is going to run on the frame
     * @return a frame
     */
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