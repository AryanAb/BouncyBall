/** VBoost.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create Vertical Booster
  */


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VBoost extends GameObject {

    /**
     *
     * @param x x coordinate of VBoost 
     * @param y y coordinate of VBoost
     * @param id ID(identity) of VBoost that is going to used to show it on the map
     */
    public VBoost(int x, int y, ID id){
        super(x, y, id);
    }

    /**
     *
     * @return 
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    /**
     *
     */
    @Override
    public void tick() {

    }

    /**To call the image of VerticalBooster and render it
     * @param g graphics
     * @return Vertical Booster Image
     */
    @Override
    public void render(Graphics g) {

        File path = new File("Assets/VerticalBooster.png");

        BufferedImage img = null;
        try {
            img = ImageIO.read(path);
        } catch (IOException e) {
            System.err.println(e);
        }

        g.drawImage(img, x, y, null);
    }
}