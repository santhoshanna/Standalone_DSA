package com.santhosh.recurssion;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int sum = fibonacci(n - 1) + fibonacci(n - 2);
        return sum;
    }
}
