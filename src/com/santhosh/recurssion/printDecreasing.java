package com.santhosh.recurssion;

import java.util.*;

public class printDecreasing {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printRecursive(n);
    }

    public static void printRecursive(int n) {
        if (n > 1) {
            System.out.println(n);
            printRecursive(n - 1);
        } else if (n == 1) {
            System.out.println(1);
        }
    }
}
