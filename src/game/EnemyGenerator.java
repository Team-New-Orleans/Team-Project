package game;

import gameObjects.*;

import java.util.Random;

public class EnemyGenerator {

    private Random randomNumberGenerator;

    public EnemyGenerator() {
        //Handler.objects.add(new FlyingDragon(0, 30 ,true));
        Handler.objects.add(new Dinosaur(800, 420 , false, Game.player));
        Handler.objects.add(new Octopus(800, 465 , false, Game.player));
        randomNumberGenerator = new Random();
    }

    public void generatingEnemy(){
        /*
        if(Handler.objects.stream().noneMatch(enemy-> enemy instanceof FlyingDragon)){
            if(randomNumberGenerator.nextBoolean()){
                Handler.objects.add(new FlyingDragon(800, 30 ,false));
            } else {
                Handler.objects.add(new FlyingDragon(0, 30 ,true));
            }
        }
        */

        if(getCountOfEnemies() < 4){
            try {
                int randomWidth;
                if(Game.player.getX() < 100){
                    randomWidth = randomNumberGenerator.ints(250, 700).findFirst().getAsInt();
                } else if(Game.player.getX() > 700){

                    randomWidth =randomNumberGenerator.ints(0, 600).findFirst().getAsInt();
                } else {
                    if(randomNumberGenerator.nextBoolean()){
                        randomWidth = randomNumberGenerator.nextInt(400);
                    } else {
                        randomWidth = randomNumberGenerator.ints(400, 800).findFirst().getAsInt();
                    }
                    if (randomWidth > Game.player.getX() - 80 && randomWidth < Game.player.getX() + 80) {
                        if (randomWidth <= Game.player.getX()) {
                            randomWidth -= 220;
                        } else {
                            randomWidth += 220;
                        }
                    }
                }

                if(randomNumberGenerator.nextBoolean()){
                    Handler.objects.add(new Dinosaur(randomWidth, 420 , false, Game.player));
                } else {
                    Handler.objects.add(new Octopus(randomWidth, 465 , true, Game.player));
                }
            } catch (IllegalArgumentException bound){
                System.out.println(bound.getMessage());
            }
        }
    }
    private int getCountOfEnemies(){
        int count = 0;
        for (int i = 0; i < Handler.objects.size(); i++) {
            if(!(Handler.objects.get(i).getID() == 2) && !(Handler.objects.get(i).getID() == 1)){
                count++;
            }
        }
        return count;
    }

}
