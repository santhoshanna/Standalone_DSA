package com.santhosh.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class firstIndexLastIndex {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int find = Integer.parseInt(br.readLine());
        firstLastIndex(a, find, 0);
        firstLastIndex(a, find, 1);
    }

    public static void firstLastIndex(int[] a, int find, int k) {

        int low = 0;
        int high = a.length - 1;
        int mid;
        int fi = -1 , li = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (find < a[mid]) {
                high = mid - 1;
            } else if (find > a[mid]) {
                low = mid + 1;
            } else {
                if(k == 0){
                    fi = mid;
                    high = mid - 1;
                }else{
                    li = mid;
                    low = mid + 1;
                }

            }
        }
        if(k ==0){
            System.out.println(fi);
        }else{
            System.out.println(li);
        }
    }
}
