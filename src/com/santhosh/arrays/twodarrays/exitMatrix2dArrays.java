package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class exitMatrix2dArrays {

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
        int dir = 0;

        int i = minr;
        int j = minc;


        while (true) {
            //East traversal until 1 is found
            dir = (dir + arr[i][j]) % 4;
            if (dir == 0) {
                j++;
            }
            //South traversal until 1 is found
            else if (dir == 1) {
                i++;
            }
            //West traversal until 1 is found
            else if (dir == 2) {
                j--;
            }
            //North traversal until 1 is found
            else if (dir == 3) {
                i--;
            }
            if (i < 0) {
                i++;
                break;
            } else if (i == arr.length) {
                i--;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (j == arr[i].length) {
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);

    }
}

