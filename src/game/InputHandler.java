package game;

import display.Display;
import gameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{


    public InputHandler(Display display){
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            Player.isMovingUp = true;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Player.isMovingDown = true;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isMovingLeft = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isMovingRight = true;
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            //Game.player.isMovingUp = false;
            Player.isMovingUp = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Player.isMovingDown = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isMovingLeft = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isMovingRight = false;
        }
    }
}
