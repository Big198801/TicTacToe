package ru.big198801.TicTacToe;

import ru.big198801.lesson1.SettingsWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final static int WIDTH = 600;
    private final static int HEIGHT = 600;
    private JButton btnStart, btnExit;
    private GameSettings gameSettings;
    private Map map;
    public JPanel jBottom;


    GameWindow(){
        setTitle("Tic-Tac-Toe");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        btnStart = new JButton("Start");
        btnExit = new JButton("Exit");
        jBottom = new JPanel(new GridLayout(1, 2));
        jBottom.add(btnStart);
        jBottom.add(btnExit);
        add(jBottom, BorderLayout.SOUTH);
        map = new Map();
        add(map);

        gameSettings = new GameSettings(this);
        btnStart.addActionListener(e -> {
            gameSettings.setVisible(true);
        });
        btnExit.addActionListener(e -> {
            System.exit(0);
        });
        setVisible(true);

    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX, sizeY, winLen);
    }
}
