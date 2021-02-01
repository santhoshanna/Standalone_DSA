package com.santhosh.arrays.onedarrays;

import java.util.Scanner;

public class findElementInAnArray {
    public static boolean find(int[] arr, int find){
        for(int i=0; i< arr.length; i++){
            if(arr[i] == find){
                System.out.println(i);
                return true;
            }
        }
        System.out.println(-1);
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        find(arr, scn.nextInt());
    }
}

//        for(int item:arr){
//            if(item > max){
//                max = item;
//                System.out.println("max: "+ max);
//            }
//        }
//        for(int item:arr){
//            if(min){
//                min = item;
//                System.out.println("min: "+ min);
//            }
//        }
