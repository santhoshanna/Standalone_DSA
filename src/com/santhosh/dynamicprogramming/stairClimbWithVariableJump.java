package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class stairClimbWithVariableJump {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n + 1];
        //System.out.println(printStairPaths(n, arr, "", qb));
        dp = tabulation(n, arr);
        System.out.println(dp[0]);
//        for (int element : dp) {
//            System.out.println(element);
//        }
    }

    public static int[] tabulation(int n, int[] arr) {
        int[] table = new int[n + 1];
        table[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; (j <= arr[i]) && (i + j <= table.length - 1); j++) {
                table[i] += table[i + j];
            }
        }
        return table;
    }

    //Not working
    public static int printStairPaths(int n, int[] arr, String path, int[] qb) {
        int count;
        if (n == 0) {
            System.out.println(path);
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        for (int i = 0; i <= arr.length - 1; i++) {
            count = 0;
            for (int j = arr[i]; (j > 0) && (n - j) >= 0; j--) {
                count += printStairPaths(n - j, arr, path + j, qb);
            }
            qb[n] = count;
        }
        return qb[0];
    }
}
