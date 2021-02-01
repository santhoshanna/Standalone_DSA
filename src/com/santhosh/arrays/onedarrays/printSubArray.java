package com.santhosh.arrays.onedarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class printSubArray {

    public static void print(int[] a){
        // write your code here
        for(int i=0; i < a.length; i++){
            for(int j=i; j < a.length; j++){
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        print(a);
    }
}

