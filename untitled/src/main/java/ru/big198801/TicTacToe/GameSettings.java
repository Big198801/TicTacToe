package ru.big198801.TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GameSettings extends JFrame {
    private static int WIDTH = 300;
    private static int HEIGHT = 350;
    private JButton btnStart;
    private JPanel jTop;
    private JLabel chooseGameMode;
    private JRadioButton btnPVP;
    private JRadioButton btnAI;
    private ButtonGroup gameModeButtonGroup;
    private JLabel mapSize = new JLabel("Выберите размер поля: ");
    private JSlider mapSizeSlider = new JSlider(JSlider.HORIZONTAL, 3, 10, 3);
    private JLabel currentMapSize = new JLabel(" ");
    private JLabel chooseWinLen = new JLabel("выберите длину выигрышной линии: " );
    private JSlider chooseWinLenSlider = new JSlider(JSlider.HORIZONTAL, mapSizeSlider.getValue(), 10, mapSizeSlider.getValue());

    private JLabel currentWinLen = new JLabel(" ");


    public GameSettings(GameWindow gameWindow) {
        setTitle("Settings");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        chooseGameMode = new JLabel("Choose a game mod: ");
        btnPVP = new JRadioButton("PVP");
        btnAI = new JRadioButton("AI");
        gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(btnPVP);
        gameModeButtonGroup.add(btnAI);
        jTop = new JPanel(new GridLayout(10, 1));
        jTop.add(chooseGameMode);
        jTop.add(btnPVP);
        jTop.add(btnAI);
        jTop.add(mapSize);
        jTop.add(currentMapSize);
        jTop.add(mapSizeSlider);
        jTop.add(chooseWinLen);
        jTop.add(currentWinLen);
        jTop.add(chooseWinLenSlider);
        btnStart = new JButton("Start new game");
        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(0, 3, 3, 3 );
        });
        jTop.add(btnStart);
        chooseWinLenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinLen.setText("установленная длина выигрышной линии: " + chooseWinLenSlider.getValue());
            }
        });
        mapSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentMapSize.setText("установленный размер поля: " + mapSizeSlider.getValue());
                chooseWinLenSlider.setMaximum(mapSizeSlider.getValue());

            }
        });
        add(jTop, BorderLayout.NORTH);


        setResizable(false);


    }
}
