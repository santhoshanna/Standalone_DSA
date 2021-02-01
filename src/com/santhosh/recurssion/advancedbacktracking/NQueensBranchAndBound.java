package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class NQueensBranchAndBound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here  //Using Brute force and backtracking
        // queenTraversal(board, 0, "");

        boolean[] cols = new boolean[n];
        boolean[] nd = new boolean[2 * n - 1];
        boolean[] rd = new boolean[2 * n - 1];
        queenTraversalBandB(board, 0, cols, nd, rd, "");
    }

    public static void queenTraversalBandB(boolean[][] board, int row, boolean[] cols, boolean[] nd, boolean[] rd, String psf) {
        if (row == board.length) {
            System.out.println(psf + ".");
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (cols[col] == false && nd[row + col] == false && rd[row - col + board.length - 1] == false && board[row][col] == false) {
                cols[col] = true;
                nd[row + col] = true;
                rd[row - col + board.length - 1] = true;
                board[row][col] = true;
                queenTraversalBandB(board, row + 1, cols, nd, rd, psf + row + "-" + col + ", ");
                cols[col] = false;
                nd[row + col] = false;
                rd[row - col + board.length - 1] = false;
                board[row][col] = false;

            }
        }
    }

    //Using Brute force and backtracking
    public static void queenTraversal(boolean[][] board, int row, String psf) {
        if (row == board.length) {
            System.out.println(psf + ".");
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col] == false && boundsCheck(board, row, col)) {
                board[row][col] = true;
                queenTraversal(board, row + 1, psf + row + "-" + col + ", ");
                board[row][col] = false;
            }
        }
    }

    //Using Brute force and backtracking
    public static boolean boundsCheck(boolean[][] board, int row, int col) {
        //top rows and diagonally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == true) {
                return false;
            }
        }

        //top rows and diagonally right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == true) {
                return false;
            }
        }

        //Vertically up and top rows
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == true) {
                return false;
            }
        }
        return true;
    }

}

