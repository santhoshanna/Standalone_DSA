package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class stockspan {
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

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        // solve
        int[] solution = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        solution[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            while (stack.size() != 0 && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                solution[i] = i + 1;
                stack.push(i);
            } else {
                solution[i] = i - stack.peek();
                stack.push(i);
            }
        }
        return solution;
    }
}
