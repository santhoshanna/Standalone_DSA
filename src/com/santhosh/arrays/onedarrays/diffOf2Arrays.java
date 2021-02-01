package com.santhosh.arrays.onedarrays;

import java.util.Scanner;

public class diffOf2Arrays {


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

        int[] diff = new int[(size1 > size2) ? size1 : size2];
        int carry = 0;
        int digitSum = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;
        while (k >= 0) {
            int arr1val = (i >= 0) ? arr1[i] : 0;
            if ((arr2[j] + carry) >= arr1val) {
                digitSum = arr2[j] - arr1val + carry;
                carry = 0;
            } else {
                digitSum = arr2[j] - arr1val + carry + 10;
                carry = -1;
            }
            diff[k] = digitSum;

            i--;
            j--;
            k--;
        }
        if (carry != 0) {
            System.out.println(carry);
        }
        int m=0;
        while (m< diff.length) {
            if(diff[m]!=0){
                break;
            }else{
                m++;
            }
        }
        while(m< diff.length){
            System.out.println(diff[m]);
            m++;
        }
    }
}

