package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class BuyAndSellStocksOneTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int leastSoFar = Integer.MAX_VALUE;
        int maxProfitSoFar = Integer.MIN_VALUE;
        int profitToday = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar = prices[i];
            }
            profitToday = prices[i] - leastSoFar;
            if (profitToday > maxProfitSoFar) {
                maxProfitSoFar = profitToday;
            }
        }
        System.out.println(maxProfitSoFar);
    }
}
