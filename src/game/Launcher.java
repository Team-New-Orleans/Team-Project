package game;

import display.Display;

public class Launcher {
    public static void main(String[] args) {
        Game game= new Game("Java Workshop", 800, 600);
        game.start();
    }
}
