package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class coinchangepermutation {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }
        int amt = scn.nextInt();

        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        System.out.println(dp[amt]);
    }
}
