package com.santhosh.stringbuilder;

import java.util.Scanner;

public class asciidifferenceStringAppend {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        // write your code here
        StringBuilder sb = new StringBuilder(str);
        StringBuilder op = new StringBuilder();
        op.append(sb.charAt(0));
        for (int i = 1; i < sb.length(); i++) {
            char current = sb.charAt(i);
            char previous = sb.charAt(i - 1);
            op.append(current - previous);
            op.append(current);
        }
        return op.toString();
    }
}
