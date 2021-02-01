package com.santhosh.datastructures.StacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicateBrackets {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                if(st.peek() == '('){
                    System.out.println(true);
                    return;
                } else {
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        System.out.println(false);
    }
}
