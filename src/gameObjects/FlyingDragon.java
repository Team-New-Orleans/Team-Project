package gameObjects;

import gfx.Assets;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by VikSUN on 2/11/2015.
 */

public class FlyingDragon extends GameObject{
    private boolean toRight; // Dragon's moving direction
    private static final int width = 219, height = 185;

    private boolean isDown = false, attackDown = false, isFalling = false; // Controls wings' position

    private int i = 1, hit = 1, death = 1;
    private int attackPoint;

    public FlyingDragon(int x, int y, boolean toRight) {
        super(x, y, width, height);
        this.toRight = toRight;
        this.setVelX(2);
        this.setVelY(9);

        this.setIsDead(false);
        this.setHealth(80);
        this.setAttackDamage(40);
        this.attackPoint = randomNumber();
        this.setIsDead(false);
    }

    @Override
    public void tick() {
        if (this.getHealth() <= 0) {
            if (hit < 39) {
                isFalling = true;
                hit++;
                this.setY(this.getY() + getVelY());
            } else if (hit >= 39) {
                death++;
                if (death % 2 == 0) {
                    this.setY(this.getY() + 1);
                }
                this.setAttackDamage(0);
                if (death >= 79) {
                    this.setIsDead(true);
                }
            }
        } else if (attack()) {
            if (!attackDown) {
                hit++;
                this.setY(this.getY() + getVelY());
                if (hit >= 39) {
                    attackDown = true;
                }
            } else {
                hit--;
                this.setY(this.getY() - getVelY());
                if (hit <= 1 && attackDown == true) {
                    if (toRight) {
                        this.setX(this.getX() + getVelX());
                    } else {
                        this.setX(this.getX() - getVelX());
                    }
                }
            }
        } else if(toRight) {
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
        if (this.getHealth() <= 0 && hit >= 39) {
            if (toRight){
                graphics.drawImage(Assets.flyingDragonDeath.crop(death / 10 * 219, 0, 219, 152), this.getX(), this.getY(), null);
            } else {
                graphics.drawImage(Assets.flyingDragonDeathReversed.crop((79 - death) / 10 * 219, 0, 219, 152), this.getX(), this.getY(), null);
            }
        } else if (attack() || isFalling) {
            if (toRight) {
                graphics.drawImage(Assets.flyingDragonAttack.crop(hit/ 10 * 212, 0, 212, 177), this.getX(), this.getY(), null);
            } else {
                graphics.drawImage(Assets.getFlyingDragonAttackReversed.crop((39 - hit)/ 10 * 212, 0, 212, 177), this.getX(), this.getY(), null);
            }
        } else if (toRight) {
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

    public int randomNumber() {
        Random random = new Random();
        return random.ints(200, 600).findFirst().getAsInt();
    }

    private boolean attack () {
        boolean attack = false;

        // Enemy attacks if it is on specific distance from the player
        if (this.getX() <= this.attackPoint + this.getVelX() && this.getX() >= this.attackPoint - this.getVelX()) {
                attack = true;
        }

        return attack;
    }

  //  @Override
    //public boolean Collision(LinkedList<GameObject> list) {
    //    for (GameObject obj : list) {
      //      if(this.intersects(obj) && obj.getID() != 3){
                //Must implement a Hit function in GameObject
        //        obj.Hit();
          //  }
        //}
        //return false;
    //}

}
