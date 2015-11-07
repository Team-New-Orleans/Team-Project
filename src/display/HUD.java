package display;

import game.Game;
import gfx.ImageLoader;

import java.awt.*;

/**
 * Created by Simooo on 6.11.2015 ã..
 */
public class HUD {

    private int greenValue = 255;
    public void tick(){
        if(Game.player.getHealth() < 200){
            greenValue = Game.player.getHealth();
        }
        if(Game.player.getHealth() < 0){
            greenValue = 0;
        }
    }
    public void render(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.fillRect(5, 15, 42, 49);
        graphics.drawImage(ImageLoader.loadImage("/Display/soldier.png"),5, 15, null);

        graphics.setColor(Color.gray);
        graphics.fillRect(50, 15, 200, 32);
        graphics.setColor(new Color(100, greenValue, 0));
        graphics.fillRect(50, 15, Game.player.getHealth(), 32);
        graphics.setColor(Color.white);
        graphics.drawRect(50, 15, 200, 32);

        for (int i = 1; i < 19; i++) {
            graphics.drawRect(50 + (i * 10), 15, 20, 32);
        }


        for (int i = 0; i < Game.player.getLife(); i++) {
           graphics.drawImage(ImageLoader.loadImage("/Display/life.png"), 260 + (i * 32), 15, null);
        }


    }
}
