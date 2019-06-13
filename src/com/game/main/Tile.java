/** Tile.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a bouncing tile
  */

import java.awt.*;

public class Tile extends GameObject {

    /**
     *
     * @param x
     * @param y
     * @param id
     */
    public Tile(int x, int y, ID id){
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

    /**To render a normal bouncing tile on the map
     * @param g
     * @return black normal bouncing tile
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 50, 50);
    }
}