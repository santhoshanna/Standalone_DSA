package com.santhosh.arrays.twodarrays;

import java.util.Scanner;

public class searchIn2dArrays {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int searchValue = scn.nextInt();

        int i = 0;
        int j = arr[0].length - 1;
        boolean found = false;
        while (i <= arr.length - 1 && j >= 0) {

            if (searchValue < arr[i][j]) {
                i++;
            } else if (searchValue > arr[i][j]) {
                j--;
            } else if (searchValue == arr[i][j]) {
                System.out.println(i);
                System.out.println(j);
                found = true;
                break;
            }
        }


//        for (int i = 0; i <= arr.length - 1; i++) {
//            for (int j = 0; j <= arr[0].length - 1; j++) {
//                if (arr[i][j] == searchValue) {
//                    System.out.println(i);
//                    System.out.println(j);
//                    found = true;
//                    break;
//                }
//            }
//        }
        if (found != true)
            System.out.println("Not Found");
    }
}

