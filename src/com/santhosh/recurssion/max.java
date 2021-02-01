package com.santhosh.recurssion;

import java.util.Scanner;

public class max {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int max = maxOfArray(arr, idx + 1);
        if (max > arr[idx]) {
            return max;
        } else {
            return arr[idx];
        }
    }
}
