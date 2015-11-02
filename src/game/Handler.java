package game;

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
        }
    }
    public void render(Graphics graphics){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(graphics);
        }
    }
}
