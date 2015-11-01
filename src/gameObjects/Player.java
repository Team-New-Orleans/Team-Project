package gameObjects;
import gfx.Assets;

import java.awt.*;

public class Player extends GameObject{

    private static final int width = 512/9, height = 512/5;
    private int i =0;
    private int health;
    private int attackDamage;
    int lastx = 20;
    public static boolean isMovingRight ;
    public static boolean isMovingLeft ;
    public static boolean isMovingUp;
    public static boolean isMovingDown;

    public Player() {
        super(20, 428, 10, 20);
        this.health = 200;
        this.attackDamage = 150;
        this.setVelX(2);
        this.setVelY(2);
    }

    @Override
    public void tick(){
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
            this.setX(this.getX() - this.getVelX());
        }

        if(isMovingUp){
            this.setY(this.getY() - this.getVelY());
        } else if(isMovingDown) {
            this.setY(this.getY() + this.getVelY());
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player.crop(0+ i*width, 0, width, height), this.getX(), this.getY(), null);
    }
}
