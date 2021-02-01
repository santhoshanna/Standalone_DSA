package com.santhosh.datastructures.HeapsAndHashmap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int key : arr) {
            hm.put(key, true);
        }
        for (int key : arr) {
            if (hm.containsKey(key - 1)) {
                hm.put(key, false);
            }
        }
        int maxLength = Integer.MIN_VALUE;
        int keyForLongestSequence = 0;
        for (int key : arr) {
            if (hm.get(key) == true) {
                int length = 1;
                int startingPoint = key;
                while (hm.containsKey(startingPoint + length)) {
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                    keyForLongestSequence = startingPoint;
                }
            }
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.println(keyForLongestSequence + i);
        }
    }
}
