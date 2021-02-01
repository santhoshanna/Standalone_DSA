package com.santhosh.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class minCostInMazeTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        //printPaths(0, 0, arr.length - 1, arr[0].length - 1, arr, "", arr[0][0]);

        int[][] dp = new int[n][m];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if ((i == dp.length - 1) && (j == dp[0].length - 1)) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    public static void printPaths(int startRow, int startCol, int maxRow, int maxCol, int[][] arr, String path, int cost) {
        if (startCol == maxCol && startRow == maxRow) {
            System.out.println("*****************");
            System.out.println(cost);
            System.out.println(path);
            System.out.println("*****************");
            return;
        }

        //travel horizontally right
        if (startCol + 1 <= maxCol) {
            printPaths(startRow, startCol + 1, maxRow, maxCol, arr, path + 'h', cost + arr[startRow][startCol + 1]);
        }
        //travel vertically down
        if (startRow + 1 <= maxRow) {
            printPaths(startRow + 1, startCol, maxRow, maxCol, arr, path + 'v', cost + arr[startRow + 1][startCol]);
        }
    }
}
