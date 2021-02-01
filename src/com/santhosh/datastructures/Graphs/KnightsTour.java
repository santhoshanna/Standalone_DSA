package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightsTour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Size of the chess board
        int n = Integer.parseInt(br.readLine());

        //Input - Starting row
        int row = Integer.parseInt(br.readLine());

        //Input - Starting col
        int col = Integer.parseInt(br.readLine());

        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);

    }

    public static void printKnightsTour(int[][] chess, int row, int col, int count) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] != 0) {
            return;
        } else if (count == 25) {
            chess[row][col] = count;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = count;
        //top right
        printKnightsTour(chess, row - 2, col + 1, (count + 1));

        //top 2nd right
        printKnightsTour(chess, row - 1, col + 2, (count + 1));

        //bottom 1st right
        printKnightsTour(chess, row + 1, col + 2, (count + 1));

        //bottom 2nd right
        printKnightsTour(chess, row + 2, col + 1, (count + 1));

        //bottom 1st left left
        printKnightsTour(chess, row + 2, col - 1, (count + 1));

        //bottom 2nd left left
        printKnightsTour(chess, row + 1, col - 2, (count + 1));

        //top 1st left
        printKnightsTour(chess, row - 1, col - 2, (count + 1));

        //top 2nd left
        printKnightsTour(chess, row - 2, col - 1, (count + 1));

        //
        chess[row][col] = 0;
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
