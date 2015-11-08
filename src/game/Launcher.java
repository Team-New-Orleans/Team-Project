package game;
import menu.MainMenu;
public class Launcher {
    public static void main(String[] args) {
        // new MainMenu(); //uncomment to see the main menu
        Game game= new Game("Java Workshop", 800, 600);
        game.start();
    }
}
