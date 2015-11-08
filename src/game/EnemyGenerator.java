package game;

import gameObjects.*;

import java.util.Random;

public class EnemyGenerator {

    private Random randomNumberGenerator;
    private static long lastTimeGenerated = System.nanoTime();
    private static long now;
    public EnemyGenerator() {
        Handler.objects.add(new FlyingDragon(0 - 100, 45, true));
        Handler.objects.add(new Dinosaur(800, 420 , false, Game.player));
        Handler.objects.add(new Octopus(800, 465 , false, Game.player));
        Handler.objects.add(new Octopus_T(400, 468, Game.player));
        randomNumberGenerator = new Random();
    }

    public void generatingEnemy(){
        if(Handler.objects.stream().noneMatch(enemy-> enemy instanceof FlyingDragon)){
            if(randomNumberGenerator.nextBoolean()){
                Handler.objects.add(new FlyingDragon(800, 45, false));
            } else {
                Handler.objects.add(new FlyingDragon(-100, 45, true));
            }
        }

        if(Handler.objects.stream().noneMatch(enemy-> enemy instanceof Octopus_T)){
            Handler.objects.add(new Octopus_T(randomNumberGenerator.ints(0,800).findFirst().getAsInt(), 468, Game.player));
        }

        now = System.nanoTime();
        double delta = now - lastTimeGenerated;
        double ns = 1_000_000_000.0;
        if(Math.abs(delta / ns) > 5){
            try {
                int randomWidth;
                if(Game.player.getX() < 100){
                    randomWidth = 800;
                } else if(Game.player.getX() > 700){
                    randomWidth = 0;
                } else {
                    if(randomNumberGenerator.nextBoolean()){
                        randomWidth = 0;
                    } else {
                        randomWidth = 800;
                    }
                }
                if(randomNumberGenerator.nextBoolean()){
                    Handler.objects.add(new Dinosaur(randomWidth, 420 , false, Game.player));
                } else {
                    Handler.objects.add(new Octopus(randomWidth, 465 , true, Game.player));
                }
                lastTimeGenerated = now;
            } catch (IllegalArgumentException bound){
                System.out.println(bound.getMessage());
            }
        }
    }
}
