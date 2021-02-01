package com.santhosh.recurssion;

import java.util.Scanner;

public class displayArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length || idx < 0) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }
}
