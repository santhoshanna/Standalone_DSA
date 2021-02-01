package com.santhosh.recurssion.backtrackking;

import java.util.Scanner;

public class targetSumSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        printTargetSumSubsets(arr, 0, "", 0, target);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sum, int target) {
        if ((target == sum) && (idx == arr.length)) {
            System.out.println(set + ".");
            return;
        }
        if (idx == arr.length) {
            return;
        }
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sum + arr[idx], target);
        printTargetSumSubsets(arr, idx + 1, set, sum, target);

    }
}
