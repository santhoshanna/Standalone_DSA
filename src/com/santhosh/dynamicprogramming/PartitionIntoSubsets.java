package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class PartitionIntoSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                    System.out.print(dp[i][j] + " ");
                } else if (j == 0) {
                    dp[i][j] = 0;
                    System.out.print(dp[i][j] + " ");
                } else if (i == 1 && j != 0) { //If i have n players who needs to be divided into 1 team, then there is only 1 way
                    dp[i][j] = 1;
                    System.out.print(dp[i][j] + " ");
                } else if (i == j) { ////If i have n players who needs to be divided into n (n==k) team, then there are n ways
                    dp[i][j] = 1;
                    System.out.print(dp[i][j] + " ");
                } else if (i > j) {////If i have n players who needs to be divided into k team, but the k teams are greater than no of players then there is 0 way
                    dp[i][j] = 0;
                    System.out.print(dp[i][j] + " ");
                } else { //Watch the video between 10 and 16 mins..
                    dp[i][j] = (i * dp[i][j - 1]) + dp[i - 1][j - 1];
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(dp[k][n]);
    }
}
