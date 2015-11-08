package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import game.Handler;

import gameObjects.GameObject;

public class CurrentScore {
	public long currentScore = 0;
	private long lastTime = System.nanoTime();
	private long now;
	private long delta;
	
	
	public void tick() {
		now = System.nanoTime();
		delta = (now - lastTime) / 1_700_000_000;
		if (delta >= 1) {
			this.currentScore+=3;
			lastTime = now;
		}
		for (int i = 0; i < Handler.objects.size(); i++) {
			GameObject object = Handler.objects.get(i);
			if (object.getIsDead() && object.getAttackDamage() == 40) {
				currentScore+=31;
			} else if (object.getIsDead() && object.getAttackDamage() == 25) {
				currentScore+=21;
			} else if (object.getIsDead() && object.getAttackDamage() == 20) {
				currentScore+=11;
			}
		}
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Impact", Font.BOLD, 20));
		graphics.drawString("current score: " + currentScore, 400, 40);
		graphics.dispose();
	}
	
	public long getCurrentScore() {
		return this.currentScore;
	}
	
	public void setCurrentScore (long score) {
		this.currentScore = score;
	}
}
