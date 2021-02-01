package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class MaxSumOfNonAdjacentElementSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prevInclude = arr[0];
        int prevExclude = 0;
        int currentInclude = 0;
        int currentExclude = 0;

        for (int i = 1; i < n; i++) {
            currentInclude = prevExclude + arr[i];
            currentExclude = Math.max(prevInclude, prevExclude);

            prevInclude = currentInclude;
            prevExclude = currentExclude;
        }
        System.out.println(Math.max(currentInclude, currentExclude));
    }
}
