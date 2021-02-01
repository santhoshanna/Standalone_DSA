package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class shellRotate2dArrays {


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

        int s = scn.nextInt();
        int r = scn.nextInt();

        int a[] = fetchShellInto1dArray(arr, s);
        System.out.println("Displaying fetched 1d array from the shell: " + s);
        display(a);
        rotate(a, s, r);
        putBack1dArrayIntoShell(a, arr, s);
        System.out.println("Displaying 2d array after putting back 1d array into the shell: " + s);
        display(arr);
    }

    public static void rotate(int a[], int s, int r) {

        r %= a.length;
        if (r < 0) {
            r += a.length;
        }

        reverse(a, a.length - r, a.length - 1);
        System.out.println("Second half after rotate index reversed");
        display(a);
        reverse(a, 0, a.length - r - 1);
        System.out.println("First half after rotate index reversed");
        display(a);
        reverse(a, 0, a.length - 1);
        System.out.println("Entire array rotated by value: " + r);
        display(a);

    }

    public static void reverse(int a[], int li, int hi) {
        while (li < hi) {
            int temp = a[li];
            a[li] = a[hi];
            a[hi] = temp;
            li++;
            hi--;
        }
    }

    public static int[] fetchShellInto1dArray(int[][] a, int s) {

        int minr = s - 1;
        int maxr = a.length - s;
        int minc = s - 1;
        int maxc = a[0].length - s;

        int size = 2 * (maxr + maxc - minr - minc);

        int[] idArray = new int[size];
        int idx = 0;

        for (int i = minr, j = minc; i <= maxr; idx++, i++) {
            idArray[idx] = a[i][j];
        }
        for (int i = maxr, j = minc + 1; j <= maxc; j++, idx++) {
            idArray[idx] = a[i][j];
        }
        for (int i = maxr - 1, j = maxc; i >= minr; idx++, i--) {
            idArray[idx] = a[i][j];
        }
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--, idx++) {
            idArray[idx] = a[i][j];
        }

        return idArray;
    }

    public static void putBack1dArrayIntoShell(int[] idArray, int[][] a, int s) {

        int minr = s - 1;
        int maxr = a.length - s;
        int minc = s - 1;
        int maxc = a[0].length - s;

        int size = 2 * (maxr + maxc - minr - minc);
        int idx = 0;

        for (int i = minr, j = minc; i <= maxr; idx++, i++) {
            a[i][j] = idArray[idx];
        }
        for (int i = maxr, j = minc + 1; j <= maxc; j++, idx++) {
            a[i][j] = idArray[idx];
        }
        for (int i = maxr - 1, j = maxc; i >= minr; idx++, i--) {
            a[i][j] = idArray[idx];
        }
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--, idx++) {
            a[i][j] = idArray[idx];
        }

    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void display(int[][] a) {
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a[i].length - 1; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

