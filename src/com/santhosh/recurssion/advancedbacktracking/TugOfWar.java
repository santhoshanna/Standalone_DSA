package com.santhosh.recurssion.advancedbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class TugOfWar {

    private static int min = Integer.MAX_VALUE;
    private static String ans = "";

    public static void solution(int[] arr, int level, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumOfSet1, int sumOfSet2) {
        if (level == arr.length) {
            if (Math.abs(set1.size() - set2.size()) <= 1) {
                if (min > Math.abs(sumOfSet1 - sumOfSet2)) {
                    min = Math.abs(sumOfSet1 - sumOfSet2);
                    ans = set1 + " " + set2;
                }
            }
            return;
        }

        //If we add the arr entity to set1
        // if (set1.size() < (arr.length + 1) / 2) {
        set1.add(arr[level]);
        sumOfSet1 += arr[level];
        solution(arr, level + 1, set1, set2, sumOfSet1, sumOfSet2);
        set1.remove(set1.size() - 1);
        sumOfSet1 -= arr[level];
        //   }

        //If we add the arr entity to set2
        // if (set2.size() < (arr.length + 1) / 2) {
        set2.add(arr[level]);
        sumOfSet2 += arr[level];
        solution(arr, level + 1, set1, set2, sumOfSet1, sumOfSet2);
        set2.remove(set2.size() - 1);
        sumOfSet2 -= arr[level];
        //  }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, 0);
        System.out.println(ans);
    }
}
