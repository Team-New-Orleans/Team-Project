package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 4/11/2015.
 */

public class Octopus extends GameObject{
    private boolean toRight; // Enemy's moving direction
    private static final int width = 59, height = 71;
    private int health = 30; // Enemy's health
    private int attackDamage = 5; // Enemy's damage power

    // Chasing target
    public GameObject target;

    private int sprite = 1;

    public Octopus(int x, int y, boolean startPos, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setVelX(1);
        this.toRight = startPos; // Starting position
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
            graphics.drawImage(Assets.octopus.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.octopusReversed.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
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


    public boolean Chase(boolean currentDirectionIsRight, GameObject gameobject) {
        boolean moveToRight;

        // Enemy changes movement direction when passes by the player. Required distance for changing direction - player's width
        if (currentDirectionIsRight == true) {
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
