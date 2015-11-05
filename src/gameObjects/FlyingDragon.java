package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 2/11/2015.
 */


public class FlyingDragon extends GameObject{
    private boolean toRight; // Dragon's moving direction
    private static final int width = 219, height = 185;

    private boolean isDown = false; // Controls wings' position

    private int i = 1;

    public FlyingDragon(int x, int y, boolean toRight) {
        super(x, y, width, height);
        this.toRight = toRight;
        this.setVelX(2);

        this.setHealth(100);
        this.setAttackDamage(10);
    }

    @Override
    public void tick() {
        if(toRight) {
            this.setX(this.getX() + getVelX());
        } else {
            this.setX(this.getX() - getVelX());
        }

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

        this.getBoundingBox().setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        if (toRight) {
            graphics.drawImage(Assets.flyingDragon.crop(i / 5 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.flyingDragonReversed.crop(i / 5 * width, 0, width, height), this.getX(), this.getY(), null);
        }
    }


   @Override
    public int getID() {
        return 3;
    }

    @Override
    public void Hit(int value) {
        this.setHealth(this.getHealth() - value);
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
