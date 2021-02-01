package com.santhosh.arrays.onedarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class rotateArray {


    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void leftRotate(int[] a) {
        // write your code here
        int temp = a[0];
        int i = 0;
        for (i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[i] = temp;
    }

    public static void rotateUneficient(int[] a, int k) {
        // write your code here
        int counter = k;
        if (counter < 0) {
            counter *= (-1);
            while (counter != 0) {
                leftRotate(a);
                counter--;
            }
        } else {
            counter = counter - a.length;
            counter *= -1;
            while (counter != 0) {
                leftRotate(a);
                counter--;
            }
        }

    }

    public static void rotate(int[] a, int k) {
        reverse(a, 0, a.length - 1 - k);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int i, int j) {

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        //rotateUneficient(a, k);
        k %= a.length;
        if (k < 0) {
            k += a.length;
        }
        rotate(a, k);
        display(a);
    }
}

