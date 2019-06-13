/** HBoost.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a horizontal booster
  */

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HBoost extends GameObject {

    //Variables  
    public int direction;

    /**Used to call HBoost in level editor, game, and levels.
     * @param x x coordinate of the HBoost
     * @param y y coordinate of the HBoost
     * @param id ID(identity) of HBoost that is going to used to show it on the map
     * @param direction direction that the ball is going to when the ball hit Hboost
     */
    public HBoost(int x, int y, ID id, int direction){
        super(x, y, id);
        this.direction = direction;
    }

    /**To create bounds of death tile
     *@return 50 pixel sized rectangle
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }


    @Override
    public void tick() {

    }

    /**To render HBoost
     * @param g graphics
     * @return deathtile image (image from the file)
     */
    @Override
    public void render(Graphics g) {

        File path = new File("Assets/HorizontalBooster.png");
        BufferedImage img = null;

        if(direction == -1) {

            try {
                img = ImageIO.read(path);
            } catch (IOException e) {
                System.err.println(e);
            }

            g.drawImage(img, x, y, null);
        } else if(direction == 1) {
            try {
                img = ImageIO.read(path);
                double rotationRequired = Math.toRadians(180);
                double locationX = img.getWidth() / 2;
                double  locationY = img.getHeight() / 2;
                AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                g.drawImage(op.filter(img, null), x, y, null);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**To set the direction of ball's motion
     * @param direction
     */
    public void setDirection(int direction) {
        // depending on the rotation of the image set direction to 1 or -1
    }

    /** To get the direction of the ball's motion
     * @return the direction of the ball
     */
    public int getDirection() {
        return direction;
    }
}