package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class Sudoku {

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        // write your code here
        if (i == board.length) {
            display(board);
            return;
        }
        int nextI = 0;
        int nextJ = 0;

        if (j == board[0].length - 1) {
            nextI = i + 1;
            nextJ = 0;
        } else {
            nextI = i;
            nextJ = j + 1;
        }
        if (board[i][j] != 0) {
            solveSudoku(board, nextI, nextJ);
        } else {
            for (int possibleValue = 0; possibleValue <= board.length; possibleValue++) {
                if (placementPossible(board, i, j, possibleValue)) {
                    board[i][j] = possibleValue;
                    solveSudoku(board, nextI, nextJ);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean placementPossible(int[][] board, int i, int j, int possibleValue) {
        //check row
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] == possibleValue) {
                return false;
            }
        }
        //check col
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == possibleValue) {
                return false;
            }
        }

        //check sub matrix
        for (int row = 3 * (i / 3); row < (3 * (i / 3)) + 3; row++) {
            for (int col = 3 * (j / 3); col < (3 * (j / 3)) + 3; col++) {
                if (board[row][col] == possibleValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        solveSudoku(arr, 0, 0);
    }
}
