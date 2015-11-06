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

    private static final int width = 142, height = 114, widthAttack = 134;

    // Chasing target
    private GameObject target;

    private int sprite = 1, hit = 1;

    public Dinosaur(int x, int y, boolean startPos, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setVelX(2);
        this.toRight = startPos; // Starting position
        this.setHealth(40);
        this.setAttackDamage(10);
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
                toRight = false; // Changes direction when hit.
                            }
        } else if (attacksLeft) {
            hit++;
            if (hit >= 39) {
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
        if (attacksRight) {
            graphics.drawImage(Assets.dinosaurAttack.crop(hit / 20 * widthAttack, 0, widthAttack, 115), this.getX(), this.getY(), null);
        } else if (attacksLeft) {
            graphics.drawImage(Assets.dinosaurAttackReversed.crop(hit / 20 * widthAttack, 0, widthAttack, 115), this.getX(), this.getY(), null);
        } else if (toRight){
            graphics.drawImage(Assets.dinosaur.crop(sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
        } else {
            graphics.drawImage(Assets.dinosaurReversed.crop( sprite / 10 * width, 0, width, height), this.getX(), this.getY(), null);
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

  //  @Override
    //public boolean Collision(LinkedList<GameObject> list) {
      //  for (GameObject obj : list) {
        //    if(this.intersects(obj) && obj.getID() != 3){
                //Must implement a Hit function in GameObject
                //obj.Hit();
       //     }
     //   }
   //     return false;
 //   }

    private int getWidthAttack() {
        return widthAttack;
    }
    private boolean Chase(boolean currentDirectionIsRight, GameObject gameobject) {
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
