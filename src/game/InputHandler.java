package game;

import display.Display;
import gameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class InputHandler implements KeyListener{


    public InputHandler(Display display){
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isMovingLeft = true;
            Player.isIdleRight = false;
            Player.isIdleLeft = false;
            Player.isMovingRight = false;


        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isMovingRight = true;
            Player.isMovingLeft = false;
            Player.isIdleRight = false;
            Player.isIdleLeft = false;


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

        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isIdleLeft = true;
            Player.isMovingLeft = false;
            Player.isIdleRight = false;
            Player.isMovingRight = false;

        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isIdleRight = true;
            Player.isMovingRight = false;
            Player.isMovingLeft = false;
            Player.isIdleLeft = false;

        }
    }
}
