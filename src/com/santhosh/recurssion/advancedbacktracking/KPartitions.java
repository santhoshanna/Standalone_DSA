package com.santhosh.recurssion.advancedbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class KPartitions {
    private static int counter = 1;

    public static void solution(int i, int n, int k, int countOfNonEmptySets, ArrayList<ArrayList<Integer>> ans) {
        //write your code here
        if (i > n) {
            if (k == countOfNonEmptySets) {
                System.out.print((counter++) + ". ");
                for (ArrayList<Integer> list : ans) {
                    System.out.print(list + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() != 0) {
                ans.get(j).add(i);
                solution(i + 1, n, k, countOfNonEmptySets, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(i);
                solution(i + 1, n, k, countOfNonEmptySets + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);
    }
}
