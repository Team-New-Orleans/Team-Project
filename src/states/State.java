package states;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Simooo on 8.11.2015 ã..
 */
public abstract class State extends JComponent {
    public abstract void tick();
    public abstract void render(Graphics g);
}
