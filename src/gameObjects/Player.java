package gameObjects;
import gfx.Assets;

import java.awt.*;

public class Player extends GameObject{

    private int health;
    private int attackDamage;
    private int velocity = 1;
    public boolean isMovingRight = false;
    public boolean isMovingLeft = false;

    public Player() {
        super(20, 428, 10, 20);
        this.health = 200;
        this.attackDamage = 150;
    }

    @Override
    public void tick() {
        // TODO up and down
        if(isMovingRight){
            this.x += this.velocity;
        }
        if(isMovingLeft){
            this.x -= this.velocity;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, this.x, this.y, null);
    }
}
