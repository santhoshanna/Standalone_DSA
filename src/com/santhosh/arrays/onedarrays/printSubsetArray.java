package com.santhosh.arrays.onedarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class printSubsetArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        print(a);
    }

    public static void print(int[] a) {
        int limit = (int) Math.pow(2, a.length);
        int counter = 0;

        for (int i = 0; i < limit; i++) {
            String set = "";
            int temp = i;
            for (int j = a.length - 1; j >= 0; j--) {
                int remainder = temp % 2;
                temp = temp / 2;
                if (remainder == 0) {
                    set = "-" + "\t" + set;
                } else {
                    set = a[j] + "\t" + set;
                }
            }
            System.out.println(set);
        }
    }
}

