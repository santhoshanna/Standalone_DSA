package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class TilingUsingMCross1Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        if (n < m) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; (i <= n); i++) {
            if (i - m >= 0) {
                dp[i] = dp[i - 1] + dp[i - m];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[n]);
    }
}
