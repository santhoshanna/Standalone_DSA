package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class BinaryCountNonConsecutive0s {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int prevZeroCount = 1, prevOneCount = 1, currentZeroCount = 0, currentOneCount = 0;

        for (int i = 2; i <= n; i++) {
            currentZeroCount = prevOneCount;
            currentOneCount = prevOneCount + prevZeroCount;

            prevZeroCount = currentZeroCount;
            prevOneCount = currentOneCount;
        }
        System.out.println(currentZeroCount + currentOneCount);
    }
}
