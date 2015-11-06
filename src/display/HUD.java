package display;

import game.Game;

import java.awt.*;

/**
 * Created by Simooo on 6.11.2015 ã..
 */
public class HUD {

    public void render(Graphics graphics){
        graphics.setColor(Color.gray);
        graphics.fillRect(15, 15, 200, 32);
        graphics.setColor(Color.red);
        graphics.fillRect(15, 15, Game.player.getHealth(), 32);
        graphics.setColor(Color.white);
        graphics.drawRect(15, 15, 200, 32);
    }
}
