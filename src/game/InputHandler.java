package game;

import display.Display;

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
            Game.player.isMovingUp = true;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Game.player.isMovingDown = true;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Game.player.isMovingLeft = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Game.player.isMovingRight = true;
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
            Game.player.isMovingUp = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Game.player.isMovingDown = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Game.player.isMovingLeft = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Game.player.isMovingRight = false;
        }
    }
}
