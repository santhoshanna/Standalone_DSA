package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfixevaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> stackOperand = new Stack<>();
        Stack<Integer> stackIntegerEvaluation = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                stackOperand.push(ch + "");
                stackIntegerEvaluation.push(ch - '0');
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                String v2 = stackOperand.pop();
                String v1 = stackOperand.pop();
                String newExpression = "(" + v1 + ch + v2 + ")";
                stackOperand.push(newExpression);

                int i2 = stackIntegerEvaluation.pop();
                int i1 = stackIntegerEvaluation.pop();
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
        //Infix Expression
        String infix = stackOperand.pop();
        System.out.println(infix);
        //Prefix Conversion
        String prefix = prefix(infix);
        System.out.println(prefix);
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
}
