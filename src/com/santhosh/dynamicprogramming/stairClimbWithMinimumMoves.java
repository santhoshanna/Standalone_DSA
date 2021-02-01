package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class stairClimbWithMinimumMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; (j <= arr[i]) && (i + j < dp.length); j++) {
                    if (dp[i + j] != null) {
                        min = (int) Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = 1 + min;
                } else {
                    dp[i] = null;
                }
            }
        }
//        for (Integer element : dp) {
//            System.out.println(element);
//        }
        System.out.println(dp[0]);
    }
}
