package ru.big198801.TicTacToe;

import javax.swing.*;
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
    private char[][] field;
    private boolean gameWork;


        void startNewGame(int mode, int sizeX, int sizeY, int winLen) {

        }

//    private boolean checkWinGame(int dot) {
//        for (int i = 0; i < fieldSizeX; i++) {
//            for (int j = 0; j < fieldSizeY; j++) {
//                if(checkLine(i, j, 1, 0, winLen, dot))return true;
//                if(checkLine(i, j, 0, -1, winLen, dot)) return true;
//                if(checkLine(i, j, 0, 1, winLen, dot)) return true;
//                if(checkLine(i, j, 1, -1, winLen, dot)) return true;
//            }
//        }
//        return false;
//    }
}
