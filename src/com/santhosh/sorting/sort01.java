package com.santhosh.sorting;

import java.util.Scanner;

public class sort01 {
    public static void sort01(int[] arr) {
        //write your code here
        partition(arr, 0, arr.length - 1, 1);

    }

    public static void partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
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
        sort01(arr);
        print(arr);
    }
}
