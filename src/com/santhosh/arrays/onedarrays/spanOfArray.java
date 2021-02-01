package com.santhosh.arrays.onedarrays;

import java.util.Scanner;

public class spanOfArray {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                //System.out.println("max: "+ max);
            }
            if(arr[i] < min){
                min = arr[i];
                //System.out.println("min: "+ min);
            }
        }

        System.out.println(max-min);
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
