package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class smallestnumberfollowingpattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                stack.push(count++);
            } else {
                stack.push(count++);
                while (stack.size() != 0) {
                    System.out.print(stack.pop());
                }
            }
        }
        stack.push(count);
        while (stack.size() != 0) {
            System.out.print(stack.pop());
        }
    }
}
