package com.santhosh.recurssion.advancedbacktracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {

    public static int getMin(String exp) {
        Stack<Character> stack = new Stack<>();
        if (exp.length() == 1) {
            return 1;
        } else {
            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String expression = scn.nextLine();
        HashSet<String> set = new HashSet<>();
        solution(expression, set, getMin(expression));
    }

    private static void solution(String expression, HashSet<String> set, int min) {
        if (min == 0) {
            int minRemovals = getMin(expression);
            if (minRemovals == 0) {
                if (!set.contains(expression)) {
                    set.add(expression);
                    System.out.println(expression);
                }
            }
            return;
        }
        for (int i = 0; i < expression.length(); i++) {
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);
            solution(left + right, set, min - 1);
        }
    }
}
