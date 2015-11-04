package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 4/11/2015.
 */


public class Dinosaur extends GameObject{
    private boolean toRight; // Dragon's moving direction

    private int health; // Dinosaur's health
    private int attackDamage; // Dinosaur's damage power

    private int sprite = 1;

    public Dinosaur(int x, int y, boolean toRight) {
        super(x, y, 142, 118); // To be changed!!
        this.toRight = toRight;
        this.setVelX(2);

        this.health = 50; // Dinosaur's health
        this.attackDamage = 10; // Dinosaurs's damage power
    }

    @Override
    public void tick() {
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
            graphics.drawImage(Assets.dinosaur.crop(sprite / 10 * 142, 0, 142, 114), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.dinosaurReversed.crop(sprite / 10 * 142, 0, 142, 114), this.getX(), this.getY(), null);
        }
    }


    @Override
    public int getID() {
        return 3;
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

}
