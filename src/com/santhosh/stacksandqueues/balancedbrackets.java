package com.santhosh.stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class balancedbrackets {
    public static boolean handleClosing(Stack stk, Character ch) {
        if (stk.size() == 0) {
            System.out.println(false);
            return false;
        } else if (stk.peek() != ch) {
            System.out.println(false);
            return false;
        } else {
            stk.pop();
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ')') {
                if (!handleClosing(stk, '(')) {
                    return;
                }
            } else if (ch == '}') {
                if (!handleClosing(stk, '{')) {
                    return;
                }
            } else if (ch == ']') {
                if (!handleClosing(stk, '[')) {
                    return;
                }
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            }
        }
        if (stk.size() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
