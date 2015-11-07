package gameObjects;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import game.Game;
import game.Handler;
import gfx.Assets;

public class Health extends GameObject {
	private static int width = 11;
	private static int height = 10;
	private static int startX;
	private static int startY;
	
	public Health (int startX, int startY) {
		super(0, 0, width, height);
		setHealth(1);
		setAttackDamage(-20);
		this.startX = startX;
		this.startY = startY;
	}
	
	private boolean collision (LinkedList<GameObject> list) {
		for (GameObject obj : list) {
            if(this.intersects(obj) && obj.getID() == 1 && obj.getHealth() < 180){
                obj.Hit(this.getAttackDamage());
                this.setHealth(0);
                this.setIsDead(true);
            } else if (this.intersects(obj) && obj.getID() == 1) {
            	this.setHealth(0);
				this.setIsDead(true);
			}
        }
        return false;
	}

	@Override
	public void tick() {
		this.getBoundingBox().setBounds(this.startX,this.startY,this.width, this.height);
		this.collision(Handler.objects);
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.health.crop(0, 0, width, height), this.startX, this.startY, null);
	}

	@Override
	public int getID() {
		return 4;
	}

	@Override
	public void Hit(int value) {
		this.setHealth(this.getHealth() - value);
	}
	public void setStartX (int newValue) {
		this.startX = newValue;
	}
	public int getStartX() {
		return this.startX;
	}
	public void setStartY (int newValue) {
		this.startY = newValue;
	}
	public int gestStartY() {
		return this.startY;
	}
}
