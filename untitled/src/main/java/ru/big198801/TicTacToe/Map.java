package ru.big198801.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private static final int PADDING = 10;
    private static final int STATE_DRAW = 3;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final int STATE_GAME = 0;
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "НИЧЬЯ!";
    private int gameStateType;
    private int width;
    private int height;
    private int cellWidth ;
    private int cellHeight;
    private int mode;
    private int winLen;
    private int fieldSizeY;
    private int fieldSizeX;
    private int[][] field;
    private boolean gameWork;

    Map(){
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameWork) {
                    update(e);
                }
            }
        });

    }
    private void initMap(){
        field = new int[fieldSizeY][fieldSizeX];
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen) {
        this.mode = mode;
        this.winLen = winLen;
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        initMap();
        gameWork = true;
        this.gameStateType = STATE_GAME;
        repaint();

    }

    private void update(MouseEvent e) {
        int x = e.getX() / cellWidth;
        int y = e.getY() / cellHeight;
        if(!isValidCell(x, y) || !isEmptyCell(x, y)){
            return;
        }
        field[y][x] = HUMAN_DOT;
       if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)){
           return;
       }
       aiTurn();
       repaint();
       checkEndGame(AI_DOT, STATE_WIN_AI);

    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isValidCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean isMapFull(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) {
                    return false;
                }
            }
        }return true;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean checkEndGame(int dot, int gameOverType){
        if (checkWinGame(dot)){
            this.gameStateType = gameOverType;
            repaint();
            return true;
        }
        else if (isMapFull()){
            this.gameStateType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }

        private boolean checkWinGame(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(checkLine(i, j, 1, 0, winLen, dot))return true;
                if(checkLine(i, j, 0, -1, winLen, dot)) return true;
                if(checkLine(i, j, 0, 1, winLen, dot)) return true;
                if(checkLine(i, j, 1, -1, winLen, dot)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int winLen, int dot) {
        int farX = x + (winLen - 1) * vx;
        int farY = y + (winLen - 1) * vy;
        if (!isEmptyCell(farX, farY)) {
            return false;
        }
        for (int i = 0; i < winLen; i++) {
            if (field[y + i * vy][x + i * vx] != dot) {
                return false;
            }
        }return true;
    }
}
