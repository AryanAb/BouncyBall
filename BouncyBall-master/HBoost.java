import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HBoost extends GameObject {

    private int direction = 1;

    public HBoost(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }

    @Override
    public void tick() {

    }

 
    @Override
    public void render(Graphics g) {

        File path = new File("E:/BouncyBall-master/Assets/HorizontalBooster.png");

        BufferedImage img = null;
        try {
            img = ImageIO.read(path);
        } catch (IOException e) {
            System.err.println(e);
        }

        g.drawImage(img, x, y, null);
    }
    public void setDirection(int direction) {
        // depending on the rotation of the image set direction to 1 or -1
    }

    public int getDirection() {
        return direction;
    }
}
