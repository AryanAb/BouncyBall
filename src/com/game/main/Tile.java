/** Tile.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To create a bouncing tile
  */

import java.awt.*;

public class Tile extends GameObject {

   /**Used to call a normal bouncing tile in level editor, game, and levels.
   * @param x x coordinate of  tile
   * @param y y coordinate of  tile
   * @param id ID(identity) of the tile that is going to used to show it on the map
   */
    public Tile(int x, int y, ID id){
        super(x, y, id);
    }

   /**To create bounds of Tile
    * @return 50 pixel sized rectangle
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