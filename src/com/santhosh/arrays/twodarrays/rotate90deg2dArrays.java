package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class rotate90deg2dArrays {

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        //transpose
        int[][] transpose = new int[n][n];
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        //transpose (reusing same array)
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i; j <= arr[0].length - 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reversal
        int[][] reverse = new int[n][n];
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                reverse[i][j] = transpose[i][arr[0].length - 1 - j];
            }
        }
        display(reverse);

        //reversal (reusing same array)
        for (int i = 0; i <= arr.length - 1; i++) {
            int li = i;
            int ri = arr.length - 1;
            while (li <= ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = arr[i][li];
                li++;
                ri--;
            }
        }

        //display rotated by 90 deg
//        for (int j = 0; j <= arr[0].length - 1; j++) {
//            for (int i = arr.length - 1; i >= 0; i--) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}

