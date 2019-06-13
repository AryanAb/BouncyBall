/** EditorHandler.java
 *  Joon Kim and Aryan Abed
 *  June 12th 2019
 *  Handles all tick, render, object in level editor
 */ 


import java.awt.*;
import java.util.LinkedList;

public class EditorHandler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();


    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}