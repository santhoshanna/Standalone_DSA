package com.santhosh.stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class duplicatebrackets {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ')') {
                if (stk.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (stk.peek() != '(') {
                        stk.pop();
                    }
                    stk.pop();
                }
            } else {
                stk.push(ch);
            }
        }
        System.out.println(false);
    }
}
