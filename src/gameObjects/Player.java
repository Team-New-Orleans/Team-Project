package gameObjects;
import gfx.Assets;

import java.awt.*;

public class Player extends GameObject{

    private static final int width = 50, height = 60;
    private int i = 0;
    private int health;
    private int attackDamage;
    int lastx = 20;
    public static boolean
            isMovingRight= false,
            isMovingLeft = false,
            isMovingUp = false,
            isMovingDown = false,
            isIdle = true;

    public Player() {
        super(20, 470, width, height);
        this.health = 200;
        this.attackDamage = 150;
        this.setVelX(2);
        this.setVelY(2);
    }

    @Override
    public void tick(){
        this.getBoundingBox().setBounds(this.getX(), this.getY(), width, height);

        // TODO up and down
        if(isMovingRight){

            if(this.getX() - lastx >= 10){
                i++;
                lastx = this.getX();
            }
            if(i>=9){
                i=0;
            }
            this.setX(this.getX() + this.getVelX());
        }
        else if(isMovingLeft){
            if(lastx - this.getX() >= 10){
                i++;
                lastx = this.getX();
            }
            if(i>=9){
                i=0;
            }
            this.setX(this.getX() - this.getVelX());
        }

//        if(isMovingUp){
//            this.setY(this.getY() - this.getVelY());
//        } else if(isMovingDown) {
//            this.setY(this.getY() + this.getVelY());
//        }
    }

    @Override
    public void render(Graphics graphics) {

        //Just to see the player Rectangle
        graphics.drawRect(this.getBoundingBox().x, this.getBoundingBox().y, this.getBoundingBox().width, this.getBoundingBox().height);
        if(isIdle){
            graphics.drawImage(Assets.player.crop(0, 60, width, height), this.getX(), this.getY(), null);
        }else if(isMovingRight){
            graphics.drawImage(Assets.player.crop(i * width, 0, width, height), this.getX(), this.getY(), null);
        }else if(isMovingLeft){
            graphics.drawImage(Assets.reversedPlayer.crop(500 - (i + 1) * width+3, 0, width, height), this.getX(), this.getY(), null);
        }
    }
}
