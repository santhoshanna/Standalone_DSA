package com.santhosh.recurssion;

import java.util.Scanner;

public class printPermutations {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printPermutations(scn.nextLine(), "");
    }

    public static void printPermutations(String str, String answer) {
        if (str.length() == 0) {
            System.out.println(answer);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            printPermutations(str.substring(0, i) + str.substring(i + 1), answer + ch);
        }
    }
}
