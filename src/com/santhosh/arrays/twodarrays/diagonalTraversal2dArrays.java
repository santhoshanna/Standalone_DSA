package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class diagonalTraversal2dArrays {


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
        int counter = 0;
        while (counter < arr.length) {
            for (int k = 0, l = counter; (k < arr.length) && (l < arr[k].length); k++, l++) {
                System.out.println(arr[k][l]);
            }
            counter++;
        }
    }
}

