package com.oxytoca.gameoflife;

import java.util.*;
public class Game {

    private byte[][] finishedBoard;
    private int generationCounter = 0;

    public byte[][] gameStart(byte[][] board) {
        nextStep(board);
        return finishedBoard;
    }
    public int getGenerationCounter() {
        return generationCounter;
    }

    private void nextStep(byte[][] board) {

        generationCounter++;
        byte[][] prevStepOnBoard = Arrays.copyOf(board, board.length);
        byte[][] currentStepBoard = neighborsScanner(board);

        if (generationCounter<1000 &&
                !Arrays.deepEquals(prevStepOnBoard, currentStepBoard)) {
            nextStep(currentStepBoard);
        }
        else {
            finishedBoard = Arrays.copyOf(currentStepBoard, currentStepBoard.length);
        }
    }
    private byte[][] neighborsScanner(byte[][] board) {
        byte[][] nextStepOnBoard = new byte[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighborsCounter = 0;

                int neighborsValue = i != 0 && board[i-1][j] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = i != 0 && j != board[i].length-1
                         && board[i-1][j+1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = j != board[i].length-1 && board[i][j+1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = j != board[i].length-1 &&
                        i != board.length-1 &&  board[i+1][j+1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = i != board.length-1 &&
                        board[i+1][j] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = j != 0 && i != board.length-1
                        &&  board[i+1][j-1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = j != 0 && board[i][j-1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                neighborsValue = j != 0 && i != 0 &&
                        board[i-1][j-1] != 0 ? 1 : 0;
                neighborsCounter += neighborsValue;

                if ((neighborsCounter < 2 ||
                        neighborsCounter > 3) && board[i][j] == 1) {
                    nextStepOnBoard[i][j] = 0;
                }
                if ((neighborsCounter == 2 ||
                        neighborsCounter == 3) && board[i][j] == 1) {
                    nextStepOnBoard[i][j] = 1;
                }
                if (neighborsCounter == 3 && board[i][j] == 0) {
                    nextStepOnBoard[i][j] = 1;
                }
            }
        }
        return nextStepOnBoard;
    }
}