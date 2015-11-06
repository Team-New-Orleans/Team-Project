package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial implements ActionListener {
    private JButton start = new JButton("New game");
    private JButton mainMenu = new JButton("Go to main menu");
    private JLabel tutorial = new JLabel(content(), SwingConstants.CENTER);
    private JLabel lifeBar = new JLabel("");
    private MainMenu m;

    public Tutorial(){
        m = new MainMenu();

        tutorial.setFont(tutorial.getFont().deriveFont(20.0f));
        tutorial.setForeground(Color.white);
        m.setLabel(tutorial);
        lifeBar.setBackground(Color.GREEN);
        lifeBar.setOpaque(true);
        m.setLifeBar(lifeBar);

        m.setButton(start, 400);
        m.setButton(mainMenu, 500);
        start.addActionListener(this);
        start.setForeground(Color.WHITE);
        start.setBounds((800-220)/2, 430, 220, 40);
        start.setContentAreaFilled(false);

        mainMenu.addActionListener(this);
        mainMenu.setForeground(Color.WHITE);
        mainMenu.setBounds((800-220)/2, 500, 220, 40);
        mainMenu.setContentAreaFilled(false);
    }
    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("New game")){
            m.JFDispose();
        } else if(comStr.equals("Go to main menu")){
            new MainMenu();
            m.JFDispose();
        }
        System.out.println(comStr + " Selected");
    }

    private String content(){
        return "<html>Jump and move player with arrows:<br>" +
                "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;" +
                "&#160;&#160;&#160&#160;&#160;&#160&#160;&#160;&#160;&lt;-- ^ --><br><br><br>" +
                "Shoot with: &lt;spacebar&gt;<br><br><br>Life bar: </html>";
    }
}
