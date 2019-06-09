

import java.awt.*;
import java.io.File;

public class Player extends GameObject {

    private Handler handler;
    private int heightTraveled = 0;
    private boolean bouncing = false;
    private boolean vBoosting = false;
    private boolean hBoosting = false;
    private boolean inputEnabled = true;

    HUD hud = new HUD();

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        setVelY(0);
        inputEnabled = true;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 26, 26);
    }

    @Override
    public void tick() {
    x += velX;
    y += velY;

    collision();
    if(bouncing) bounce();
    if(vBoosting) vBoost();
    if(hBoosting) hBoost();
    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BounceTile) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if (getY() + 26 > tempObject.getBounds().y - 5 && getY() + 26 < tempObject.getBounds().y + 5){
                        bouncing = true;
                    } else {
                        velX = 0;
                        velY = +3;
                        inputEnabled = true;
                    }
                }
            } else if(tempObject.getId() == ID.DeathTile) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    System.out.println("You died");
                }
            }
            if(tempObject.getId() == ID.Star) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    /*try {
                        File file = new File("C:/Users/aryan/IdeaProjects/BouncyBall/Assets/smw_coin.wav");
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                        clip.open(ais);
                        clip.start();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }*/
                    Star star = new Star(0, 0, null);
                    star.playSound();
                    handler.removeObject(tempObject);
                }
            }
            if(tempObject.getId() == ID.VBoost){
                // simplify the if statements
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(getY() + 26 > tempObject.getBounds().y - 5 && getY() + 26 < tempObject.getBounds().y + 5){
                        vBoosting = true;
                    } else {
                        velX = 0;
                    }
                }
            }
            if(tempObject.getId() == ID.HBoost){
                if(getBounds().intersects(tempObject.getBounds())) {
                    hBoosting = true;
                }
            }
        }
    }

    private void bounce() {

        setVelY(-3);
        heightTraveled += getVelY();
        if(heightTraveled == -99){
            setVelY(+3);
            bouncing = false;
            heightTraveled = 0;
        }

    }

    private void vBoost() {
        //setVelY(-4);
        velY = -4;
        vBoosting = false;
        inputEnabled = false;
    }

    private void hBoost() {
        //HBoost h = new HBoost(0, 0, ID.HBoost);
        //setVelX(h.getDirection() * 4);
        velX = +4;
        velY = 0;
        hBoosting = false;
        inputEnabled = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 26, 26);
    }
}
