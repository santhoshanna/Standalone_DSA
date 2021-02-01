package com.santhosh.stringbuilder;

import java.util.Scanner;

public class toggleCases {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scn.nextLine());

        //System.out.println(s);

        //int start = (int) System.currentTimeMillis();
        //char[] ch = new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isUpperCase(s.charAt(i))) {
//                s.setCharAt(i, Character.toLowerCase(s.charAt(i)));
//            } else if (Character.isLowerCase(s.charAt(i))) {
//                s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
//            }
//        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                s.setCharAt(i, (char) (ch + 'a' - 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                s.setCharAt(i, (char) (ch + 'A' - 'a'));
            }
        }

        System.out.println(s.toString());
        //int end = (int) System.currentTimeMillis();
        //int duration = (end - start);
    }
}
