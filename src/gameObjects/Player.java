package gameObjects;
import gfx.Assets;

import java.awt.*;

public class Player extends GameObject{

    private static final int width = 50, height = 60;
    private int i = 0;
    private int health;
    private int attackDamage;
    int lastDrawnPosition = 20;
    public static boolean
            isMovingRight= false,
            isMovingLeft = false,
            isMovingUp = false,
            isMovingDown = false,
            isIdleLeft = false,
            isIdleRight = true;


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
        if(isMovingRight){

            if(this.getX() - lastDrawnPosition >= 10){
                i++;
                lastDrawnPosition = this.getX();
            }
            if(i>=9){
                i=0;
            }
            if(this.getX() >= 752){

            } else {
                this.setX(this.getX() + this.getVelX());
            }
        } else if(isMovingLeft){
            if(lastDrawnPosition - this.getX() >= 10){
                i++;
                lastDrawnPosition = this.getX();
            }
            if(i>=9){
                i=0;
            }
            if(this.getX() <= 4){

            } else {
                this.setX(this.getX() - this.getVelX());
            }

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
        if(isIdleRight){
            graphics.drawImage(Assets.player.crop(0, 60, width, height), this.getX(), this.getY(), null);
        } else if(isIdleLeft){
            graphics.drawImage(Assets.reversedPlayer.crop(450, 60, width, height), this.getX(), this.getY(), null);
        } else if(isMovingRight){
            graphics.drawImage(Assets.player.crop(i * width, 0, width, height), this.getX(), this.getY(), null);
        }else if(isMovingLeft){
            graphics.drawImage(Assets.reversedPlayer.crop(500 - (i + 1) * width+3, 0, width, height), this.getX(), this.getY(), null);
        }
    }
}
