package com.oxytoca.gameoflife;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        Game game = new Game();

        byte[][] gameBoard = {{0, 0, 0, 0, 0},
                              {0, 0, 1, 0, 0},
                              {0, 1, 1, 1, 0},
                              {0, 0, 1, 0, 0},
                              {0, 0, 0, 0, 0}};

        System.out.println("Output of the initial state:");
        for (byte b[] : gameBoard) {
            System.out.println(Arrays.toString(b));
        }

        byte[][] finalBoard = game.gameStart(gameBoard);

        if (game.getGenerationCounter()>=1000) {
            System.out.println("The limit on the number of generations has been exceeded!");
            System.out.println("The last generated colony will be displayed.");
        }

        System.out.println("Output of the final colony");
        for (byte b[] : finalBoard) {
            System.out.println(Arrays.toString(b));
        }
    }
}