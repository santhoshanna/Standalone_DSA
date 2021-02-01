package com.santhosh.recurssion.advancedbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class KPartitionsTargetSum {

    public static void solution(int[] arr, int level, int n, int k, int[] subsetSum, int countOfNonEmptySets, ArrayList<ArrayList<Integer>> listOfSubsets) {
        if (level == n) {
            if (countOfNonEmptySets == k) {
                boolean flag = true;
                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (ArrayList<Integer> list : listOfSubsets) {
                        System.out.print(list + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = listOfSubsets.get(i);
            if (list.size() > 0) {
                list.add(arr[level]);
                subsetSum[i] += arr[level];
                solution(arr, level + 1, n, k, subsetSum, countOfNonEmptySets, listOfSubsets);
                subsetSum[i] -= arr[level];
                list.remove(list.size() - 1);
            } else {
                list.add(arr[level]);
                subsetSum[i] += arr[level];
                solution(arr, level + 1, n, k, subsetSum, countOfNonEmptySets + 1, listOfSubsets);
                subsetSum[i] -= arr[level];
                list.remove(list.size() - 1);
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        // if k is equal to 1, then whole array is your answer
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        //if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr, 0, n, k, subsetSum, 0, ans);
    }
}
