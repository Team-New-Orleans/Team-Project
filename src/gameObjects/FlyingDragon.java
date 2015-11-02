package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 2/11/2015.
 */


public class FlyingDragon extends GameObject{
    private boolean toRight; // Dragon's moving direction

    private int health; // Dragon's health
    private int attackDamage; // Dragon's damage power

    private boolean isDown = false; // Controls wings' position

    private int i = 1;

    public FlyingDragon(int x, int y, boolean toRight) {
        super(x, y, 20, 40); // To be changed!!
        this.toRight = toRight;
        this.setVelX(5);

        this.health = 50; // Dragon's health
        this.attackDamage = 10; // Dragon's damage power
    }

    @Override
    public void tick() {
        if(toRight) {
            this.setX(this.getX() + getVelX());
            if (! isDown){
                i++;
            } else {
                i--;
            }

            if (i >= 24) {
                isDown = true;
            } else if (i <= 0) {
                isDown = false;
            }
        } else {
            this.setX(this.getX() - getVelX());
            if (! isDown){
                i++;
            } else {
                i--;
            }

            if (i >= 24) {
                isDown = true;
            } else if (i <= 1) {
                isDown = false;
            }
        }

        this.getBoundingBox().setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        switch (i / 5) {
            case 0:
                graphics.drawImage(Assets.flyingDragon.crop(185, 0, 182, 171), this.getX(), this.getY(), null);
                break;
            case 1:
                graphics.drawImage(Assets.flyingDragon.crop(0, 245, 181, 154), this.getX(), this.getY(), null);
                break;
            case 2:
                graphics.drawImage(Assets.flyingDragon.crop(0, 122, 183, 122), this.getX(), this.getY(), null);
                break;
            case 3:
                graphics.drawImage(Assets.flyingDragon.crop(0, 0, 184, 121), this.getX(), this.getY(), null);
                break;
            case 4:
                graphics.drawImage(Assets.flyingDragon.crop(184, 172, 177, 117), this.getX(), this.getY(), null);
                break;
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
