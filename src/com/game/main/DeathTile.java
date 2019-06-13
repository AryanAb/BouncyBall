/** DeadTile.java
 *  Aryan Abed and Joon Kim
 *  June 12th 2019
 *  To create a death tile
 */

import java.awt.*;

public class DeathTile extends GameObject {

  /**Used to call a death tile in level editor, game, and levels.
   * @param x x coordinate of death tile
   * @param y y coordinate of death tile
   * @param id ID(identity) of the death tile that is going to used to show it on the map
   */
  
  public DeathTile(int x, int y, ID id){
        super(x, y, id);
    }

    
    /**To create bounds of death tile
      * @return 50 pixel sized rectangle
      */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    @Override
    public void tick() {

    }

    /**To render deathtile
     * @param g graphics
     * @return deathtile image (red rectangle)
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 50, 50);
    }
}