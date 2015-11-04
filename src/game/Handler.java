package game;

import display.Display;
import gameObjects.GameObject;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Simooo on 1.11.2015 ã..
 */
public class Handler {
    public static LinkedList<GameObject> objects = new LinkedList<>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();

            // Removes a game object which has left the canvas.
            if ((tempObject.getX() + tempObject.getWidth() * 2  <= 0 ) || (tempObject.getX() >= 800 + tempObject.getWidth() * 2)) {
                objects.remove(i);
            }
        }
    }
    public void render(Graphics graphics){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(graphics);
        }
    }
}
