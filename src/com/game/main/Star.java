/** Star.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a star
  */

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Star extends GameObject {

    /**Used to call a star in level editor, game, and levels.
     * @param x x coordinate of the star
     * @param y y coordinate of the star
     * @param id ID (identity) of star that is going to used to show it on the map
     */
    public Star(int x, int y, ID id){
        super(x, y, id);
    }

   /**To create bounds of star
    * @return 25 pixel sized rectangle
    */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }

    /**
     *
     */
    @Override
    public void tick() {

    }

    /**Creates a bling sound when player collides with star
     * @return bling sound when player has collided with star
     */
    public static void playSound(){
        try {
            File file = new File("Assets/smw_coin.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**To call the image of star and render it
     * @param g graphics
     * @return star image
     */
    @Override
    public void render(Graphics g) {

        File path = new File("Assets/Star.png");

        BufferedImage img = null;
        try {
            img = ImageIO.read(path);
        } catch (IOException e) {
            System.err.println(e);
        }

        g.drawImage(img, x, y, null);
    }
  
}