package com.santhosh.recurssion;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
