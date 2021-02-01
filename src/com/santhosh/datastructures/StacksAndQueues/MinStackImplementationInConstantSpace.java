package com.santhosh.datastructures.StacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinStackImplementationInConstantSpace {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            // write your code here
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val < min) {
                int oldMin = min;
                min = val;
                data.push(val + val - oldMin);
            } else {
                data.push(val);
            }
        }

        int pop() {
            // write your code here
            if (data.size() != 0) {
                if (min > data.peek()) {
                    int originalVal = min;
                    int fakeVal = data.pop();
                    min = (2 * originalVal) - fakeVal;
                    return originalVal;
                } else {
                    return data.pop();
                }
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top() {
            // write your code here
            if (data.size() != 0) {
                if (min > data.peek()) {
                    return min;
                } else {
                    return data.peek();
                }
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int min() {
            // write your code here
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }

}
