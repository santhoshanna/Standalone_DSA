package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class infixtopostfixprefixconversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        System.out.println(postfix(exp));
        System.out.println(prefix(exp));
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    public static String prefix(String exp) {
        Stack<String> stackOperandPrefix = new Stack<>();
        Stack<Character> stackOperatorPrefix = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                stackOperatorPrefix.push(ch);
            } else if (ch == ')') {
                while (stackOperatorPrefix.peek() != '(') {
                    char operator = stackOperatorPrefix.pop();
                    String v2 = stackOperandPrefix.pop();
                    String v1 = stackOperandPrefix.pop();
                    stackOperandPrefix.push(("" + operator + v1 + v2));
                }
                stackOperatorPrefix.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (stackOperatorPrefix.size() != 0 && stackOperatorPrefix.peek() != '(' && (precedence(ch) <= precedence(stackOperatorPrefix.peek()))) {
                    char operator = stackOperatorPrefix.pop();
                    String v2 = stackOperandPrefix.pop();
                    String v1 = stackOperandPrefix.pop();
                    stackOperandPrefix.push(("" + operator + v1 + v2));
                }
                stackOperatorPrefix.push(ch);
            } else if (Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
                stackOperandPrefix.push(ch + "");
            }
        }
        while (stackOperatorPrefix.size() != 0) {
            char operator = stackOperatorPrefix.pop();
            String v2 = stackOperandPrefix.pop();
            String v1 = stackOperandPrefix.pop();
            stackOperandPrefix.push(("" + operator + v1 + v2));
        }
        return stackOperandPrefix.pop();
    }

    public static String postfix(String exp) {
        Stack<String> stackOperandPostfix = new Stack<>();
        Stack<Character> stackOperatorPostfix = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                stackOperatorPostfix.push(ch);
//                System.out.println("After detecting (: " + stackOperandPrefix);
//                System.out.println("After detecting (: " + stackOperatorPrefix);
            } else if (ch == ')') {
                while (stackOperatorPostfix.peek() != '(') {
                    char operator = stackOperatorPostfix.pop();
                    String v2 = stackOperandPostfix.pop();
                    String v1 = stackOperandPostfix.pop();
                    stackOperandPostfix.push(("" + v1 + v2 + operator));
                }
                stackOperatorPostfix.pop();
//                System.out.println("After detecting ): " + stackOperandPrefix);
//                System.out.println("After detecting ): " + stackOperatorPrefix);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (stackOperatorPostfix.size() != 0 && stackOperatorPostfix.peek() != '(' && (precedence(ch) <= precedence(stackOperatorPostfix.peek()))) {
                    char operator = stackOperatorPostfix.pop();
                    String v2 = stackOperandPostfix.pop();
                    String v1 = stackOperandPostfix.pop();
                    stackOperandPostfix.push(("" + v1 + v2 + operator));

//                    System.out.println("After detecting +, -, * , /: " + stackOperandPrefix);
//                    System.out.println("After detecting +, -, * , /: " + stackOperatorPrefix);
                }
                stackOperatorPostfix.push(ch);
            } else if (Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
                stackOperandPostfix.push(ch + "");
            }
        }
        while (stackOperatorPostfix.size() != 0) {
//            System.out.println("External While: " + stackOperandPrefix);
//            System.out.println("External While: " + stackOperatorPrefix);
            char operator = stackOperatorPostfix.pop();
            String v2 = stackOperandPostfix.pop();
            String v1 = stackOperandPostfix.pop();
            stackOperandPostfix.push(("" + v1 + v2 + operator));
        }
//        System.out.println("Before returning: " + stackOperandPrefix);
//        System.out.println("Before returning: " + stackOperatorPrefix);
        return stackOperandPostfix.pop();
    }

}
