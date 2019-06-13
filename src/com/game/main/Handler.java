/** Handler.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * 
  */


import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    /**
     *
     */
    public void tick() {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    /**
     *
     * @param object
     */
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    /**
     *
     * @param object
     */
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}