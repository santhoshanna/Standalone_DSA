package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class prefixevaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> stackOperand = new Stack<>();
        Stack<Integer> stackIntegerEvaluation = new Stack<>();
        Stack<String> stackPostfix = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                stackOperand.push(ch + "");
                stackPostfix.push(ch + "");
                stackIntegerEvaluation.push(ch - '0');
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                //Infix
                String v1 = stackOperand.pop();
                String v2 = stackOperand.pop();
                String infixExpression = "(" + v1 + ch + v2 + ")";
                stackOperand.push(infixExpression);

                //Postfix
                String p1 = stackPostfix.pop();
                String p2 = stackPostfix.pop();
                String postFixExpression = "" + p1 + p2 + ch;
                stackPostfix.push(postFixExpression);

                //Integer
                int i1 = stackIntegerEvaluation.pop();
                int i2 = stackIntegerEvaluation.pop();
                if (ch == '+') {
                    stackIntegerEvaluation.push(i1 + i2);
                } else if (ch == '-') {
                    stackIntegerEvaluation.push(i1 - i2);
                } else if (ch == '*') {
                    stackIntegerEvaluation.push(i1 * i2);
                } else if (ch == '/') {
                    stackIntegerEvaluation.push(i1 / i2);
                }
            }
        }
        //Evaluation
        System.out.println(stackIntegerEvaluation.pop());
        System.out.println(stackOperand.pop());
        System.out.println(stackPostfix.pop());
    }
}
