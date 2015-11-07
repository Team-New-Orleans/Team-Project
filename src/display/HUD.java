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
        graphics.setColor(Color.gray);
        graphics.fillRect(35, 15, 200, 32);
        graphics.setColor(new Color(100, greenValue, 0));
        graphics.fillRect(35, 15, Game.player.getHealth(), 32);
        graphics.setColor(Color.white);
        graphics.drawRect(35, 15, 200, 32);
        graphics.drawImage(ImageLoader.loadImage("/face.png"), 5, 15, null);
    }
}
