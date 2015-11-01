package gameObjects;
import gfx.Assets;

import java.awt.*;

public class Player extends GameObject{

    private static final int width = 512/9, height = 512/5;
    private int i =0;
    private int health;
    private int attackDamage;
    int lastx = 20;
    public boolean isMovingRight ;
    public boolean isMovingLeft ;

    public Player() {
        super(20, 428, 10, 20);
        this.health = 200;
        this.attackDamage = 150;
        this.setVelX(1);
        this.setVelY(1);
        isMovingLeft = false;
        isMovingRight = true;
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
            this.x += this.velX;
        }
        if(isMovingLeft){
            this.setX(this.getX() - this.getVelX());
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player.crop(0+ i*width, 0, width, height), this.getX(), this.getY(), null);
    }
}
