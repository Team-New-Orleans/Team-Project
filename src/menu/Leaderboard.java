package menu;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.Buffer;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class Leaderboard implements ActionListener {
    private JButton start = new JButton("New game");
    private JButton mainMenu = new JButton("Go to main menu");
    private JLabel titleScreen = new JLabel("Leaderboard", SwingConstants.CENTER);
    private JLabel leaderBoard = new JLabel(content(), SwingConstants.CENTER);
    private MainMenu m;

    private final String fontType = "Times New Roman";

    public Leaderboard() throws IOException{
        m = new MainMenu();
        titleScreen.setFont(new Font(fontType, Font.PLAIN, 72));
        titleScreen.setForeground(Color.WHITE);
        titleScreen.setBounds((800 - 480) / 2, 70, 480, 40 + 10);
        leaderBoard.setFont(leaderBoard.getFont().deriveFont(20.0f));
        leaderBoard.setForeground(Color.red);
        m.getJFrame().add(titleScreen);
        m.setLeaderBoard(leaderBoard);
        m.setButton(start, 400);
        m.setButton(mainMenu, 500);

        start.addActionListener(this);
        start.setForeground(Color.WHITE);
        start.setBounds((800 - 220) / 2, 430, 220, 40);
        start.setContentAreaFilled(false);

        mainMenu.addActionListener(this);
        mainMenu.setForeground(Color.WHITE);
        mainMenu.setBounds((800 - 220) / 2, 500, 220, 40);
        mainMenu.setContentAreaFilled(false);
    }

    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("New game")) {
            m.JFDispose();
        } else if (comStr.equals("Go to main menu")) {
            new MainMenu();
            m.JFDispose();
        }
        System.out.println(comStr + " Selected");
    }

    private String content() throws IOException {
        StringBuilder results = new StringBuilder();
        try(BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader("C:\\Users\\Simooo\\Desktop\\Team-Project\\The-Undertaker\\Resources\\Leaderboard.txt"))){
            String playerStats;
            results.append("<html>");
            while (!((playerStats=bufferedReader.readLine())==null)){
                results.append(playerStats + "<br><br>");
            }
            results.append("<html>");
        } catch (NoSuchElementException ex){
            System.out.print("Leaders not found");
        }
        System.out.print(results.toString());
        return String.format("%s", results.toString());
    }
}