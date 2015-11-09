package gameObjects;

import gfx.Assets;

import java.awt.*;

/**
 * Created by Administrator on 8/11/2015.
 */
public class Octopus_T extends GameObject {
    private boolean attacks;

    private static final int width = 59, height = 67;

    // Chasing target
    public GameObject target;

    private int sprite = 1, death = 1, start = 1;

    public Octopus_T(int x, int y, GameObject target) {
        super(x, y, width, height);
        this.target = target;
        this.setHealth(10);
        this.setAttackDamage(0);
        this.setIsDead(false);
        this.getBoundingBox().setBounds(this.getX(), this.getY(), width, 0);
    }


    @Override
    public void tick() {
        start++;
        if (start >= 100) {
            if(start == 100)
                this.getBoundingBox().setBounds(this.getX(), this.getY(), width, height);
            if (this.getHealth() <= 0) {
                death++;
                if (death >= 10) {
                    this.setIsDead(true);
                }
            } else {
                setAttackDamage(10);
                sprite++;
                if (sprite >= 120) {
                    this.setHealth(0);
                    this.setAttackDamage(0);
                }
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        if (this.getHealth() <= 0 || start < 100) {
            graphics.drawImage(Assets.octopus_tDeath.crop(0, 0, 30, 15), this.getX(), this.getY() + 55, null);
        } else {
            graphics.drawImage(Assets.octopus_t.crop(sprite / 8 * this.getWidth(), 0, this.getWidth(), this.getHeight()), this.getX(), this.getY(), null);
        }
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void Hit(int value) {

    }
}
