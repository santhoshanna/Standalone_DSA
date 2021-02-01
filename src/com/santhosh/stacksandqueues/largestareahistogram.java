package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class largestareahistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        //Find next smallest element on the right hand side for each element in the original array and capture that into an array.
        //This will constitute the right boundary
        int[] rb = new int[a.length];
        rb[a.length - 1] = a.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(a.length - 1);

        for (int i = a.length - 2; i >= 0; i--) {
            while (stack.size() != 0 && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                rb[i] = a.length;
            } else {
                rb[i] = stack.peek();
            }
            stack.push(i);
        }

//        for (int i : rb) {
//            System.out.println(i);
//        }

        //Find next smallest element on the left hand side for each element in the original array and capture that into an array.
        //This will constitute the left boundary
        int[] lb = new int[a.length];
        lb[0] = -1;
        stack.clear();
        stack.push(0);

        for (int i = 1; i < a.length; i++) {
            while (stack.size() != 0 && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = stack.peek();
            }

            stack.push(i);
        }
/*        System.out.println("***********");
        for (int i : lb) {
            System.out.println(i);
        }*/

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, (rb[i] - lb[i] - 1) * (a[i]));
        }
        // System.out.println("***********");
        System.out.println(max);
    }
}
