package com.santhosh.sorting;

import java.util.Scanner;

public class sort012 {

    public static void sort012(int[] arr) {
        //write your code here
//        int range = 3;
//        int[] freqArray = new int[range];
//        for (int i = 0; i < arr.length; i++) {
//            freqArray[arr[i]]++;
//        }
//        for (int i = 1; i < freqArray.length; i++) {
//            freqArray[i] += freqArray[i - 1] - 1;
//        }
//        int[] sortedArray = new int[arr.length];
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int val = arr[i];
//            int idx = freqArray[val];
//            sortedArray[idx] = val;
//            freqArray[val]--;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sortedArray[i];
//        }
//        print(arr);
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }
}
