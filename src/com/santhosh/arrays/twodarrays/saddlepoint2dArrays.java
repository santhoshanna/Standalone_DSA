package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class saddlepoint2dArrays {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr[i].length; j++) {
//                System.out.println(arr[i][j]);
//            }
//        }
        for (int i = 0; i <= arr.length - 1; i++) {
            int svj = 0;
            int minimum = arr[i][svj];

            //Find the min element in a row
            for (int j = 1; j <= arr[0].length - 1; j++) {
                if (arr[i][j] < minimum) {
                    minimum = arr[i][j];
                    svj = j;
                }
            }
            //Find if the min element is the max in its column (find if there is anything less than that)
            boolean saddlePointFound = true;
            for (int k = 0; k <= arr.length - 1; k++) {
                if (arr[k][svj] > minimum) {
                    saddlePointFound = false;
                    break;
                }
            }
            if (saddlePointFound == true) {
                System.out.println(minimum);
                return;
            }

        }
        System.out.println("Invalid input");
    }
}

