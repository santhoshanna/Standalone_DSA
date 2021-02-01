package com.santhosh.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class tagetSumPair {

    public static void targetSumPair(int[] arr, int target) {
        //write your code here

        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (j >= arr[i - 1]) {
                            if (dp[i - 1][j - arr[i - 1]]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }
}
