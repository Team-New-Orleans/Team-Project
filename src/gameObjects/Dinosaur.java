package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 4/11/2015.
 */

public class Dinosaur extends GameObject{
    private boolean toRight; // Enemy's moving direction
    private boolean attacksRight;
    private boolean attacksLeft;

    private static final int width = 142, height = 114;
    private int health = 50; // Dinosaur's health
    private int attackDamage = 10; // Dinosaur's damage power

    // Chasing target
    public GameObject target;

    private int sprite = 1;
    private int hit = 1;


    public Dinosaur(int x, int y, boolean startPos, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setVelX(2);
        this.toRight = startPos; // Starting position
    }

    @Override
    public void tick() {
        toRight = Chase(toRight, target);
        attacksRight = AttackOnRight(toRight, target);
        attacksLeft = AttackOnLeft(toRight, target);

        if (attacksRight) {
            hit++;
            if (hit >= 39) {
                this.setX(this.getX() + getVelX());
                hit = 1;
                            }
        } else if (attacksLeft) {
            hit++;
            if (hit >= 39) {
                this.setX(this.getX() - getVelX());
                hit = 1;
                            }
        } else if(toRight) {
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
        if (attacksRight) {
            graphics.drawImage(Assets.dinosaurAttack.crop(hit / 20 * 134, 0, 134, 115), this.getX(), this.getY(), null);
        } else if (attacksLeft) {
            graphics.drawImage(Assets.dinosaurAttackReversed.crop(hit / 20 * 134, 0, 134, 115), this.getX(), this.getY(), null);
        } else if (toRight){
            graphics.drawImage(Assets.dinosaur.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.dinosaurReversed.crop( sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
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
            if (this.getX() >= gameobject.getX() + (gameobject.getWidth() * 3)) {
                moveToRight = false;
            } else {
                moveToRight = true;
            }
        } else {
            if (this.getX() + this.getWidth() + gameobject.getWidth() * 2 <= gameobject.getX()) {
                moveToRight = true;
            } else {
                moveToRight = false;
            }
        }

        return  moveToRight;
    }

    public boolean AttackOnRight(boolean currentDirectionIsRight, GameObject player) {
        boolean AttackOnRight = false;

        // Enemy attacks if it is on specific distance from the player
        if (currentDirectionIsRight == true) {
            if (player.getX() == this.getX() + this.getWidth()) { // Overlapping for better visualisation??
                AttackOnRight = true;
            }
        }

        return AttackOnRight;
    }

    public boolean AttackOnLeft(boolean currentDirectionIsRight, GameObject player) {
        boolean AttackOnLeft = false;

        // Enemy attacks if it is on specific distance from the player
        if (currentDirectionIsRight == false) {
            if (player.getX() + player.getWidth()  ==  this.getX()) { // Overlapping for better visualisation??
                AttackOnLeft = true;
            }
        }

        return AttackOnLeft;
    }
}
