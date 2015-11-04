package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 4/11/2015.
 */


public class Dinosaur extends GameObject{
    private boolean toRight; // Enemy's moving direction
    private static final int width = 142, height = 114;
    private int health; // Dinosaur's health
    private int attackDamage; // Dinosaur's damage power

    // Chasing target
    public GameObject target;

    private int sprite = 1;

    public Dinosaur(int x, int y, boolean startPos, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setVelX(2);
        this.toRight = startPos; // Starting position
        this.health = 50; // Dinosaur's health
        this.attackDamage = 10; // Dinosaurs's damage power
    }

    @Override
    public void tick() {
        toRight = Chase(toRight, target);
        if(toRight) {
            this.setX(this.getX() + getVelX());
            sprite++;
        } else {
            this.setX(this.getX() - getVelX());
            sprite++;
        }

        if (sprite >= 29) {
            sprite = 1;
        }

        this.getBoundingBox().setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        if (toRight) {
            graphics.drawImage(Assets.dinosaur.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.dinosaurReversed.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        }
    }


    @Override
    public int getID() {
        return 4;
    }

    @Override
    public boolean Collision(LinkedList<GameObject> list) {
        for (GameObject obj : list) {
            if(this.intersects(obj) && obj.getID() != 3){
                //Must implement a Hit function in GameObject
                //obj.Hit();
            }
        }
        return false;
    }

    public boolean Chase(boolean currentDirection, GameObject gameobject) {
        boolean moveToRight;

        // If enemy is on the right side of player - moving to left => toRight = false;
        if (currentDirection == true) {
            if (this.getX() >= gameobject.getX() + (gameobject.getWidth() * 2)) {
                moveToRight = false;
            } else {
                moveToRight = true;
            }
        } else {
            if (this.getX() + this.getWidth() + gameobject.getWidth() <= gameobject.getX()) {
                moveToRight = true;
            } else {
                moveToRight = false;
            }
        }

        return  moveToRight;
    }
}
