package com.santhosh.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ceilAndFloor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        findCeilAndFloor(a, Integer.parseInt(br.readLine()));
    }

    public static void findCeilAndFloor(int[] a, int find) {

        int low = 0;
        int high = a.length - 1;
        int mid;
        int ceil = 0;
        int floor = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (find < a[mid]) {
                high = mid - 1;
                ceil = a[mid];
            } else if (find > a[mid]) {
                low = mid + 1;
                floor = a[mid];
            } else {
                ceil = floor = a[mid];
                break;
            }
        }
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
