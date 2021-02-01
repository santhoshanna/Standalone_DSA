package com.santhosh.recurssion.backtrackking;

import java.util.Scanner;

public class knightTour {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        int startingRow = scn.nextInt();
        int startingColumn = scn.nextInt();
        printKnightsTour(chess, startingRow, startingColumn, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int count) {
        if (count == chess.length * chess.length) {
            displayBoard(chess);
        }
        chess[row][col] = count;
        //1
        if (isKnightMovePossible(chess, row - 2, col + 1) == true) {
            chess[row - 2][col + 1] = count + 1;
            printKnightsTour(chess, row - 2, col + 1, count + 1);
            chess[row - 2][col + 1] = 0;
        }
        //2
        if (isKnightMovePossible(chess, row - 1, col + 2) == true) {
            chess[row - 1][col + 2] = count + 1;
            printKnightsTour(chess, row - 1, col + 2, count + 1);
            chess[row - 1][col + 2] = 0;
        }

        //3
        if (isKnightMovePossible(chess, row + 1, col + 2) == true) {
            chess[row + 1][col + 2] = count + 1;
            printKnightsTour(chess, row + 1, col + 2, count + 1);
            chess[row + 1][col + 2] = 0;
        }

        //4
        if (isKnightMovePossible(chess, row + 2, col + 1) == true) {
            chess[row + 2][col + 1] = count + 1;
            printKnightsTour(chess, row + 2, col + 1, count + 1);
            chess[row + 2][col + 1] = 0;
        }

        //5
        if (isKnightMovePossible(chess, row + 2, col - 1) == true) {
            chess[row + 2][col - 1] = count + 1;
            printKnightsTour(chess, row + 2, col - 1, count + 1);
            chess[row + 2][col - 1] = 0;
        }

        //6
        if (isKnightMovePossible(chess, row + 1, col - 2) == true) {
            chess[row + 1][col - 2] = count + 1;
            printKnightsTour(chess, row + 1, col - 2, count + 1);
            chess[row + 1][col - 2] = 0;
        }

        //7
        if (isKnightMovePossible(chess, row - 1, col - 2) == true) {
            chess[row - 1][col - 2] = count + 1;
            printKnightsTour(chess, row - 1, col - 2, count + 1);
            chess[row - 1][col - 2] = 0;
        }

        //8
        if (isKnightMovePossible(chess, row - 2, col - 1) == true) {
            chess[row - 2][col - 1] = count + 1;
            printKnightsTour(chess, row - 2, col - 1, count + 1);
            chess[row - 2][col - 1] = 0;
        }
        chess[row][col] = 0;

    }

    public static boolean isKnightMovePossible(int[][] chess, int row, int col) {

        if (row < 0) {
            return false;
        }
        if (row >= chess.length) {
            return false;
        }
        if (col < 0) {
            return false;
        }
        if (col >= chess[0].length) {
            return false;
        }
        if (chess[row][col] > 0) {
            return false;
        }
        return true;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
