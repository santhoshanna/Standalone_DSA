package com.santhosh.sorting;

import java.util.Scanner;

public class targetsumpair {

    public static void targetSumPair(int[] arr, int target) {
        //write your code here
        arr = mergeSort(arr, 0, arr.length - 1);
        //       System.out.print("Sorted Array -> ");
        //       print(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                System.out.println(arr[i++] + ", " + arr[j--]);
            }
        }
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            int[] baseArray = new int[1];
            baseArray[0] = arr[lo];
            return baseArray;
        }
        int mid = (lo + hi) / 2;
        int[] lsa = mergeSort(arr, lo, mid);
        int[] rsa = mergeSort(arr, mid + 1, hi);
        int[] mergedArray = mergeTwoSortedArrays(lsa, rsa);
        return mergedArray;
    }

    public static int[] mergeTwoSortedArrays(int[] lsa, int rsa[]) {
        int[] fullSortedArray = new int[lsa.length + rsa.length];
        int i = 0, j = 0, k = 0;
        while (i < lsa.length && j < rsa.length) {
            if (lsa[i] < rsa[j]) {
                fullSortedArray[k++] = lsa[i++];
            } else {
                fullSortedArray[k++] = rsa[j++];
            }
        }
        while (i < lsa.length) {
            fullSortedArray[k++] = lsa[i++];
        }
        while (j < rsa.length) {
            fullSortedArray[k++] = rsa[j++];
        }
        return fullSortedArray;
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
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }
}
