package game;

import gameObjects.*;

import java.util.Random;

public class EnemyGenerator {
    private Random randomNumberGenerator;
    private Player player;

    public EnemyGenerator(Player player) {
        this.player = player;
        Handler.objects.add(new FlyingDragon(800, 30 ,false));
        Handler.objects.add(new Dinosaur(800, 420 , false, this.player));
        Handler.objects.add(new Octopus(800, 465 , true, this.player));
        randomNumberGenerator = new Random();
    }

    public void generatingEnemy(){
        if(Handler.objects.stream().noneMatch(enemy-> enemy instanceof FlyingDragon)){
            Handler.objects.add(new FlyingDragon(800, 30 ,false));
        }
        if(getCountOfEnemies() < 3){
            int randomEnemy = randomNumberGenerator.nextInt(2);
            int randomWidth = randomNumberGenerator.nextInt(800);
            if(this.player.getX() < 100){
                randomWidth = this.player.getX() + 300;
            }
            else {
                if (randomWidth > this.player.getX() - 70 && randomWidth < this.player.getX() + 70) {
                    if (randomWidth < player.getX()) {
                        randomWidth -= 100;
                    } else {
                        randomWidth += 100;
                    }
                }
            }
                if(randomEnemy == 0){

                    Handler.objects.add(new Dinosaur(randomWidth, 420 , false, this.player));
                } else {
                    Handler.objects.add(new Octopus(randomWidth, 465 , true, this.player));
                }


        }
    }
    private int getCountOfEnemies(){
        int count = 0;
        for (int i = 0; i < Handler.objects.size(); i++) {
            if(!(Handler.objects.get(i) instanceof Bullet) && !(Handler.objects.get(i) instanceof Player)){
                count++;
            }
        }
        return count;
    }

}
