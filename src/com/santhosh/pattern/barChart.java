package com.santhosh.pattern;

import java.util.Scanner;

public class barChart {
    public static void printChart(int[] arr, int max){
        //System.out.println("max: "+ max);
        for(int floor = max; floor>=1; floor--){
            for (int i=0; i< arr.length; i++) {
                if(arr[i]>=floor){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }System.out.println("");
        }
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i:arr){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        printChart(arr, findMax(arr));
    }
}

