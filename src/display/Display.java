package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class Display extends Canvas {

    private int width,height;
    private String title;

    // our tools to draw
    private JFrame jframe;
    private Canvas canvas;

    public Display( String title, int width, int height ) {
        this.width = width;
        this.height = height;
        this.title = title;

        this.createFrame();
    }

    // this is creating our Java window where the game is displayed
    private void createFrame(){
        // dimension holds the size of our screen so we can tell to Canvas
        Dimension dimension = new Dimension(this.width, this.height);

        this.jframe = new JFrame(this.title);
        this.jframe.setSize(this.width, this.height);

        this.jframe.setVisible(true);
        this.jframe.setResizable(false);

        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
        // Canvas we do not want it to be resizable because this will mess our resolution
        this.canvas = new Canvas();
        this.canvas.setMaximumSize(dimension);
        this.canvas.setMinimumSize(dimension);
        this.canvas.setPreferredSize(dimension);

        // we are giving our Jframe the canvas
        this.jframe.add(this.canvas);
        this.jframe.pack(); // fitting the subcomponents

    }

    public void dispose(){
        jframe.dispose();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
