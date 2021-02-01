package com.santhosh.recurssion;

import java.util.Scanner;

public class printIncreasing {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n);
    }

    public static void printIncreasing(int n) {
        if (n <= 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }
}
