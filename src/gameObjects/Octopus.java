package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VikSUN on 4/11/2015.
 */

public class Octopus extends GameObject{
    private boolean toRight; // Enemy's moving direction
    private boolean attacksRight;
    private boolean attacksLeft;

    private static final int width = 59, height = 71, widthAttack = 60, heightAttack = 76;

    // Chasing target
    public GameObject target;

    private int sprite = 1, hit = 1, death = 1;

    public Octopus(int x, int y, boolean startPos, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setVelX(1);
        this.toRight = startPos; // Starting position
        this.setHealth(60);
        this.setAttackDamage(25);
        this.setIsDead(false);
    }

    @Override
    public void tick() {
        toRight = Chase(toRight, target);
        attacksRight = AttackOnRight(toRight, target);
        attacksLeft = AttackOnLeft(toRight, target);



        if (this.getHealth() <= 0) {
            death++;
            this.setAttackDamage(0);
            if (death >= 19) {
                this.setIsDead(true);
                death = 1;
            }
        } else if (attacksRight) {
            hit++;
            if (hit >= 19) {
                this.setX(this.getX() + getVelX());
                hit = 1;
                toRight = false; // Changes direction when hit.
            }
        } else if (attacksLeft) {
            hit++;
            if (hit >= 19) {
                this.setX(this.getX() - getVelX());
                hit = 1;
                toRight = true; // Changes direction when hit.
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
        if (this.getHealth() <= 0) {
            graphics.drawImage(Assets.octopusDeath.crop(0, 0, 58, 62), this.getX(), this.getY(), null);
        } else if (attacksLeft || attacksRight){
            graphics.drawImage(Assets.octopusAttack.crop(0, hit / 5 * heightAttack, width, height), this.getX(), this.getY(), null);
        }else if (toRight) {
            graphics.drawImage(Assets.octopus.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.octopusReversed.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
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

    //@Override
    //public boolean Collision(LinkedList<GameObject> list) {
      //  for (GameObject obj : list) {
        //    if(this.intersects(obj) && obj.getID() != 3){
                //Must implement a Hit function in GameObject
                //obj.Hit();
          //  }
        //}
        //return false;
    //}

    public int getWidthAttack() {
        return widthAttack;
    }
    private boolean Chase(boolean currentDirectionIsRight, GameObject gameobject) {
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


    private boolean AttackOnRight(boolean currentDirectionIsRight, GameObject player) {
        boolean AttackOnRight = false;

        // Enemy attacks if it is on specific distance from the player
        if (currentDirectionIsRight == true) {
            if (player.getX() == this.getX() + this.getWidthAttack() - 15 && player.getY() == 470 ) { // Attacks only the player is on the ground. OVERLAPPING
                AttackOnRight = true;
            }
        }

        return AttackOnRight;
    }

    private boolean AttackOnLeft(boolean currentDirectionIsRight, GameObject player) {
        boolean AttackOnLeft = false;

        // Enemy attacks if it is on specific distance from the player
        if (currentDirectionIsRight == false) {
            if (player.getX() + player.getWidth()  ==  this.getX() + 15 && player.getY() == 470) { // Attacks only the player is on the ground. . OVERLAPPING
                AttackOnLeft = true;
            }
        }


        return AttackOnLeft;
    }
}
