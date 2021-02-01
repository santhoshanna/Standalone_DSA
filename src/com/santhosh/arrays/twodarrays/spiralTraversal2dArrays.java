package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class spiralTraversal2dArrays {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int counter = 0;
        int limit = maxr * maxc;

        while (counter < limit) {
            //left
            for (int i = minr, j = minc; i <= maxr && counter < limit; i++) {
                System.out.println(arr[i][j]);
                counter++;
            }
            minc++;

            //bottom
            for (int i = maxr, j = minc; j <= maxc && counter < limit; j++) {
                System.out.println(arr[i][j]);
                counter++;
            }
            maxr--;

            //right
            for (int i = maxr, j = maxc; i >= minr && counter < limit; i--) {
                System.out.println(arr[i][j]);
                counter++;
            }
            maxc--;

            //top
            for (int i = minr, j = maxc; j >= minc && counter < limit; j--) {
                System.out.println(arr[i][j]);
                counter++;
            }
            minr++;
        }

    }
}

