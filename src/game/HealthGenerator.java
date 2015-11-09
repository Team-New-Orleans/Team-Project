package game;
import java.util.Random;

import game.Handler;
import gameObjects.Health;


public class HealthGenerator {
	private long lastTime = System.nanoTime();
	private long now = System.nanoTime();
	private double delta;
	private Health health;
	private boolean wasInTheList = true;
	
	public HealthGenerator() {
        health = new Health(new Random().nextInt(600) + 100,new Random().nextInt(400) + 100);
        Handler.objects.add(health);
	}
	
	public void generatingHealth() {
		if (Handler.objects.stream().noneMatch(health -> health instanceof Health) && wasInTheList) {
			wasInTheList = false;
			now = System.nanoTime();
			lastTime = now;
		} else if (Handler.objects.stream().noneMatch(health -> health instanceof Health)) {
			now = System.nanoTime();
			delta = (now - lastTime) / 20_000_000_000.0;
			if (delta >= 1) {
				health = new Health(new Random().nextInt(600) + 100,new Random().nextInt(400) + 100);
				Handler.objects.add(health);
			}
		}
		if (!Handler.objects.stream().noneMatch(health -> health instanceof Health)) {
			wasInTheList = true;
		}
	}
}
