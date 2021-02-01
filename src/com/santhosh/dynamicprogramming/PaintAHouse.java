package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class PaintAHouse {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] colour = new int[n][3];

        for (int i = 0; i < colour.length; i++) {
            for (int j = 0; j < colour[0].length; j++) {
                colour[i][j] = scn.nextInt();
            }
        }

        long table[][] = new long[n][3];
        table[0][0] = colour[0][0];
        table[0][1] = colour[0][1];
        table[0][2] = colour[0][2];

        for (int i = 1; i < n; i++) {
            table[i][0] = colour[i][0] + Math.min(table[i - 1][1], table[i - 1][2]);
            table[i][1] = colour[i][1] + Math.min(table[i - 1][0], table[i - 1][2]);
            table[i][2] = colour[i][2] + Math.min(table[i - 1][0], table[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(table[n - 1][0], table[n - 1][1]), table[n - 1][2]));
    }

}
