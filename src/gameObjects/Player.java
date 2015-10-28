package gameObjects;
import java.awt.*;

public class Player extends GameObject{

    private int health;
    private int attackDamage;

    public Player(int x, int y, int width, int height,  int health, int attackDamage) {
        super(x, y, width, height);
        this.health = health;
        this.attackDamage = attackDamage;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {

    }


}
