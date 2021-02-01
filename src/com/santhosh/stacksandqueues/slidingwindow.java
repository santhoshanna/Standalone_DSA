package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class slidingwindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // nge with index
        int[] ngei = new int[n];
        ngei[n - 1] = n;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (stack.size() != 0 && a[i] >= a[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                ngei[i] = a.length;
            } else {
                ngei[i] = stack.peek();
            }
            stack.push(i);
        }
//        for (int element : ngei
//        ) {
//            System.out.println(element);
//        }

        //
        for (int i = 0; i <= a.length - k; i++) {
            int j = i; //Pointer to the next greater than array element. Don't increment it. Instead see if the index is within window, if not than that
            //is already pointing to the biggest number outside the window.
            while (ngei[j] < k + i) {
                j = ngei[j];
            }
            System.out.println(a[j]);
        }
    }
}
