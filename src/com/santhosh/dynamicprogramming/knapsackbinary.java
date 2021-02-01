package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class knapsackbinary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wts = new int[n];
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        //Top down DP
        int[][] table = new int[n + 1][cap + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (j < wts[i - 1]) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(vals[i - 1] + table[i - 1][j - wts[i - 1]], table[i - 1][j]);
                }
            }
        }
        System.out.println(table[n][cap]);
        System.out.println(knapsack(wts, vals, cap, n));
        System.out.println(knapsack(wts, vals, cap, n, 0));
        System.out.println(knapsackMem(wts, vals, cap, n));
    }

    //Recursive from the last element in the array
    public static int knapsack(int[] wt, int[] val, int cap, int n) {
        int maxProfit = 0;
        if (n == 0 || cap == 0) {
            return 0;
        }

        if (wt[n - 1] <= cap) {
            maxProfit += Math.max(val[n - 1] + knapsack(wt, val, cap - wt[n - 1], n - 1), knapsack(wt, val, cap, n - 1));
        } else {
            maxProfit += knapsack(wt, val, cap, n - 1);
        }
        return maxProfit;
    }

    //Recursive from the first element in the array
    public static int knapsack(int[] wt, int[] val, int cap, int n, int startIndex) {
        int maxProfit = 0;
        if (startIndex > n - 1 || cap == 0) {
            return 0;
        }
        if (wt[startIndex] <= cap) {
            maxProfit += Math.max(val[startIndex] + knapsack(wt, val, cap - wt[startIndex], n, startIndex + 1), knapsack(wt, val, cap, n, startIndex + 1));
        } else {
            maxProfit += knapsack(wt, val, cap, n, startIndex + 1);
        }
        return maxProfit;
    }

    //Recursive from the last element in the array with memoisation
    public static int knapsackMem(int[] wt, int[] val, int cap, int n) {
        int maxProfit = 0;
        int table[][] = new int[n + 1][cap + 1];

        if (n == 0 || cap == 0) {
            return 0;
        }
        if (table[n - 1][wt[n - 1]] != 0) {
            return table[n - 1][wt[n - 1]];
        }
        if (wt[n - 1] <= cap) {
            maxProfit += Math.max(val[n - 1] + knapsack(wt, val, cap - wt[n - 1], n - 1), knapsack(wt, val, cap, n - 1));
            table[n - 1][wt[n - 1]] = maxProfit;
        } else {
            maxProfit += knapsack(wt, val, cap, n - 1);
            table[n - 1][wt[n - 1]] = maxProfit;
        }
        return maxProfit;
    }
}
