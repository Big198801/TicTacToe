package ru.big198801.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {
    private static int WIDTH = 300;
    private static int HEIGHT = 400;
    private JButton btnStart;


    public GameSettings(GameWindow gameWindow) {
        setTitle("Settings");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);
        btnStart = new JButton("Start new game");
        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(0, 3, 3, 3 );
        });
        add(btnStart);

    }
}
