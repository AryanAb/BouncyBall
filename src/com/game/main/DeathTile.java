/** DeadTile.java
 *  Aryan Abed and Joon Kim
 *  June 12th 2019
 *  To create a death tile
 */

import java.awt.*;

public class DeathTile extends GameObject {

    public DeathTile(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 50, 50);
    }
}