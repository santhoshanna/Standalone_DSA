package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class fibonnacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n + 1];
        System.out.println(fibonacci(n, arr));
    }

    public static int fibonacci(int n, int[] qb) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int sum = fibonacci(n - 1, qb) + fibonacci(n - 2, qb);
        qb[n] = sum;
        return sum;
    }
}
