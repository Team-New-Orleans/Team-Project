package game;

import display.Display;
import gameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class InputHandler implements KeyListener{
    private static long lastTime = System.nanoTime();
    private static long now;


    public InputHandler(Display display){
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isTurnedRight = false;
            Player.isMovingLeft = true;
            Player.isIdle = false;
            Player.isTurnedLeft = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isTurnedLeft = false;
            Player.isMovingRight = true;
            Player.isTurnedRight = true;
            Player.isIdle = false;
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (keyCode == KeyEvent.VK_UP) {
            Player.hasJumped = true;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            now = System.nanoTime();
            long delta = now - lastTime;
            if (Math.abs(delta) >= 400000000) {
                Player.isShooting = true;
                lastTime = now;
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            Player.isIdle = true;
            Player.isMovingLeft = false;

        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            Player.isMovingRight = false;
            Player.isIdle = true;
        }
        if(keyCode == KeyEvent.VK_SPACE){
            Player.isShooting = false;
        }
    }
}
