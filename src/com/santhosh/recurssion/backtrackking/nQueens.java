package com.santhosh.recurssion.backtrackking;

import java.util.Scanner;

public class nQueens {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        //base
        if ((row == chess.length)) {
            System.out.println(qsf + ".");
            return;
        }

        //down
        for (int col = 0; col < chess[0].length; col++) {
            if (safetyCheck(chess, row, col) == true) { //row check, col check, row diagonal check, col diagonal check
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean safetyCheck(int[][] chess, int row, int col) {
        boolean isSafe = true;
        //Tops rows & vertically up
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        //Top rows & diagonally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        //Top rows & diagonally right
        for (int i = row - 1, j = col + 1; i >= 0 && j <= chess[0].length - 1; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        //Bottom rows & vertically down
//        for (int i = row + 1, j = col; i <= chess.length - 1; i++) {
//            if (chess[i][j] == 1) {
//                return false;
//            }
//        }
//
//        //Bottom rows & diagonally left
//        for (int i = row + 1, j = col - 1; i <= chess.length - 1 && j >= 0; i++, j--) {
//            if (chess[i][j] == 1) {
//                return false;
//            }
//        }
//
//        //Bottom rows & diagonally right
//        for (int i = row + 1, j = col + 1; i <= chess.length - 1 && j <= chess[0].length - 1; i++, j++) {
//            if (chess[i][j] == 1) {
//                return false;
//            }
//        }
//
//        //Columns left
//        for (int i = row, j = col - 1; j >= 0; j--) {
//            if (chess[i][j] == 1) {
//                return false;
//            }
//        }
//
//        //Columns right
//        for (int i = row, j = col + 1; j <= chess[0].length - 1; j++) {
//            if (chess[i][j] == 1) {
//                return false;
//            }
//        }
        return isSafe;
    }
}
