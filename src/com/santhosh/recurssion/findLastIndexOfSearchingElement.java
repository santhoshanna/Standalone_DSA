package com.santhosh.recurssion;

import java.util.Scanner;

public class findLastIndexOfSearchingElement {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();
        System.out.println(lastIndex(arr, arr.length - 1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx < 0) {
            return -1;
        }
        if (arr[idx] == x) {
            return idx;
        } else return lastIndex(arr, idx - 1, x);
    }

    //When zero is passed as the index first
//    public static int lastIndex(int[] arr, int idx, int x) {
//        if (idx == arr.length) {
//            return -1;
//        }
//        int liisa = lastIndex(arr, idx + 1, x);
//        if (liisa == -1) {
//            if (arr[idx] == x) {
//                return idx;
//            } else return -1;
//        } else {
//            return idx;
//        }
//    }
}
