package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class ButAndSellInfiniteTransactionsWithTransactionFees {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int transactionFees = scn.nextInt();

        int profit = 0;
        int buy = 0;
        int sell = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {
                sell++;
            } else {
                sell = i - 1;
                profit += prices[sell] - prices[buy] - transactionFees;
                sell = buy = i;
            }
        }
        profit += prices[sell] - prices[buy] - transactionFees;
        System.out.println(profit);
    }
}
