package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class PairFriends {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        if (n == 0 || n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
        }

        System.out.println(dp[n]);
    }
}
