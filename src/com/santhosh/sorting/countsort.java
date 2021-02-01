package com.santhosh.sorting;

import java.util.*;

public class countsort {

    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int range = max - min;
        int[] frequencyArray = new int[range + 1];
        for (int i = 0; i < arr.length; i++) {
            frequencyArray[arr[i] - min] += 1;
        }
        //Sum of prefixes
        for (int i = 1; i < frequencyArray.length; i++) {

            frequencyArray[i] += frequencyArray[i - 1];
        }
        int[] sortedArray = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = frequencyArray[val - min];
            int idx = pos - 1;
            sortedArray[idx] = val;
            frequencyArray[val - min]--;
        }
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = sortedArray[i];
        }
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}
