package com.santhosh.datastructures.HeapsAndHashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Occurance1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int size1 = Integer.parseInt(scn.nextLine());
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(scn.nextLine());
        }

        int size2 = Integer.parseInt(scn.nextLine());
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(scn.nextLine());
        }

        HashMap<Integer, Integer> hm1 = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            if (hm1.containsKey(arr1[i])) {
                hm1.put(arr1[i], hm1.get(arr1[i]) + 1);
            } else {
                hm1.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (hm1.containsKey(arr2[i])) {
                System.out.println(arr2[i]);
                hm1.remove(arr2[i]);
            }
        }
    }
}
