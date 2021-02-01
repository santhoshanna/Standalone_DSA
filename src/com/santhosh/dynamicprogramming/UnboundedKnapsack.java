package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }

        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = scn.nextInt();
        }

        int capacity = scn.nextInt();

        int[] table = new int[capacity + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < val.length; j++) {
                if (wt[j] <= i) {
                    table[i] = Math.max(val[j] + table[i - wt[j]], table[i]);
                }
            }
        }
        System.out.println(table[capacity]);
    }
}
