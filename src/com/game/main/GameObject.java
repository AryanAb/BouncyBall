/** GameObject.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * 
  */

import java.awt.*;

public abstract  class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    /**
     *
     * @param x
     * @param y
     * @param id
     */
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param id
     */
    public void setId(ID id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public ID getId() {
        return id;
    }

    /**
     *
     * @param velX
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     *
     * @param velY
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     *
     * @return
     */
    public int getVelX() {
        return velX;
    }

    /**
     *
     * @return
     */
    public int getVelY() {
        return velY;
    }

}