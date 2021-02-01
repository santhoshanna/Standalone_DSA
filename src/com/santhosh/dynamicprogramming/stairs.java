package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class stairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       // int[] qb = new int[n + 1];
        //System.out.println(steps(n, "", qb));

        int[] table = tabulation(n);
        for (int i = 0; i < table.length; i++) {
            System.out.println("value at " + i + ": " + table[i]);
        }
    }

    public static int steps(int n, String path, int[] qb) {
        if (n == 0) {
            System.out.println(path);
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            System.out.println(path);
            return qb[n];
        }
        int count1 = steps(n - 1, path + 1, qb);
        int count2 = steps(n - 2, path + 2, qb);
        int count3 = steps(n - 3, path + 3, qb);
        int count = count1 + count2 + count3;

        qb[n] = count;
        return count;
    }

    public static int[] tabulation(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 1; i < table.length; i++) {
            if (i == 1) {
                table[i] = table[i - 1];
            } else if (i == 2) {
                table[i] = table[i - 1] + table[i - 2];
            } else {
                table[i] = table[i - 1] + table[i - 2] + table[i - 3];
            }
        }
        return table;
    }
}
