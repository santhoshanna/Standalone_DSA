package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class nextgreatertoright {

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

//    public static int greater(int[] arr, int startIndex, int target) {
//        for (int i = startIndex; i < arr.length; i++) {
//            if (arr[i] > target) {
//                return arr[i];
//            }
//        }
//        return -1;
//    }
//
//    public static int[] solve(int[] arr) {
//        int[] solution = new int[arr.length];
//        // solve
//        for (int i = 0; i < arr.length; i++) {
//            solution[i] = greater(arr, i + 1, arr[i]);
//        }
//        return solution;
//    }

    public static int[] solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] solution = new int[arr.length];
        stack.push(arr[arr.length - 1]);
        solution[arr.length - 1] = -1;

        for (int j = arr.length - 2; j >= 0; j--) {
            while ((stack.size() != 0) && (stack.peek() < arr[j])) {
                stack.pop();
            }
            if (stack.size() == 0) {
                solution[j] = -1;
                stack.push(arr[j]);
            } else {
                solution[j] = stack.peek();
                stack.push(arr[j]);
            }
        }
        return solution;
    }

    public static int[] getNextGreatest(int[] arr) {
        int[] solution = new int[arr.length];
        solution[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            solution[i] = Math.max(solution[i + 1], arr[i + 1]);
        }
        return solution;
    }
}
