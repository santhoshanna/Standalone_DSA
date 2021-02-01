package com.santhosh.sorting;

import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class radixsort {

    public static void radixSort(int[] arr) {
        // write code here

        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp = exp * 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        int[] freqArray = new int[10];
        for (int i = 0; i < arr.length; i++) {
            freqArray[(arr[i] / exp) % 10]++;
        }
        //convert the freqArray into sum of prefix array
        for (int i = 1; i < freqArray.length; i++) {
            freqArray[i] += freqArray[i - 1];
        }
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = freqArray[(arr[i] / exp) % 10];
            int idx = pos - 1;
            sortedArray[idx] = arr[i];
            freqArray[arr[i] / exp % 10]--;
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = sortedArray[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }
}
