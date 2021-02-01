package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class infixexpression {

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else return -1;
    }

    public static boolean lessPriority(char ipChar, char stackChar) {
        if (ipChar == '*') {
            switch (stackChar) {
                case '/':
                case '*':
                    return false;
                case '+':
                case '-':
                    return true;
            }
        } else if (ipChar == '/') {
            switch (stackChar) {
                case '/':
                case '*':
                    return false;
                case '+':
                case '-':
                    return true;
            }
        } else if (ipChar == '+') {
            return false;
        }
        return false;
    }

    public static int operation(int first, int second, char operator) {
        if (operator == '+') {
            return first + second;
        } else if (operator == '-') {
            return first - second;
        } else if (operator == '*') {
            return first * second;
        } else {
            return first / second;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> stackOperand = new Stack<>();
        Stack<Character> stackOperator = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                stackOperand.push(ch - '0');
            } else if (ch == '(') {
                stackOperator.push(ch);
            } else if (ch == ')') {
                while (stackOperator.peek() != '(') {
                    int second = stackOperand.pop();
                    char operator = stackOperator.pop();
                    int first = stackOperand.pop();
                    stackOperand.push(operation(first, second, operator));
                }
                stackOperator.pop(); //Pop the closing brace
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                //!lessPriority(ch, stackOperator.peek())
                //Process higher or equal precedence operators before closing braces arrives or stack size is 0 with their operators ny popping
                while (stackOperator.size() != 0 && stackOperator.peek() != '(' && precedence(ch) <= precedence(stackOperator.peek())) {
                    char operator = stackOperator.pop();
                    int second = stackOperand.pop();
                    int first = stackOperand.pop();
                    stackOperand.push(operation(first, second, operator));
                }
                stackOperator.push(ch);
            }
        }
        //Process remaining elements
        while (stackOperator.size() != 0) {
            int second = stackOperand.pop();
            char operator = stackOperator.pop();
            int first = stackOperand.pop();
            stackOperand.push(operation(first, second, operator));
        }
        System.out.println(stackOperand.peek());
    }
}
