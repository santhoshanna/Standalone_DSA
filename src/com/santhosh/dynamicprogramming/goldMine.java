package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class goldMine {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        //You need to come down in last col as you need j+1 (diagonally upwards) to be solved..
        for (int j = dp[0].length - 1; j >= 0; j--) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if ((j == dp[0].length - 1)) {
                    dp[i][j] = arr[i][j];
                } else if ((i == dp.length - 1)) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else if ((i == 0)) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + findMax(dp[i + 1][j + 1], dp[i][j + 1], dp[i - 1][j + 1]);
                }
            }
        }

        int max = dp[0][0];
        for (int eachRowFirstElement = 1; eachRowFirstElement <= dp.length - 1; eachRowFirstElement++) {
            max = Math.max(max, dp[eachRowFirstElement][0]);
        }
        System.out.println(max);
    }

    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
