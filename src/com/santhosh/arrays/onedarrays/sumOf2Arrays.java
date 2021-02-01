package com.santhosh.arrays.onedarrays;

import java.util.Scanner;

public class sumOf2Arrays {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size1 = scn.nextInt();
        int[] arr1 = new int[size1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }

        int size2 = scn.nextInt();
        int[] arr2 = new int[size2];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }

        int[] sum = new int[(size1 > size2) ? size1 : size2];
        int carry = 0;
        int digitSum = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;
        while (k >= 0) {
            digitSum = carry;
            if (i >= 0) {
                digitSum += arr1[i];
            }
            if (j >= 0) {
                digitSum += arr2[j];
            }
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sum[k] = digitSum;
            i--;
            j--;
            k--;
        }
        if (carry != 0) {
            System.out.println(carry);
        }
        for (int item : sum) {
            System.out.println(item);
        }
    }
}

