package com.santhosh.datastructures.HeapsAndHashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Occurance2 {
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

        for (int key : arr1) {
            if (hm1.containsKey(key)) {
                hm1.put(key, hm1.get(key) + 1);
            } else {
                hm1.put(key, 1);
            }
        }
        for (int key : arr2) {
            if (hm1.containsKey(key) && hm1.get(key) > 0) {
                System.out.println(key);
                hm1.put(key, hm1.get(key) - 1);
            }
        }
    }
}
