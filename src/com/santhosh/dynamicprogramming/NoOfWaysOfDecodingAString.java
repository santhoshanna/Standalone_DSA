package com.santhosh.dynamicprogramming;

import java.util.Scanner;

//Very Very important
//https://leetcode.com/problems/decode-ways/discuss/970075/All-4-Approaches-(Recursion-to-DP-evolve)
public class NoOfWaysOfDecodingAString {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();

        int[] table = new int[input.length()];
        table[0] = 1; //There is 1 encoding if the string has 0 characters..
        table[1] = input.charAt(1) == '0' ? 0 : 1; //If the first character is 0, then no ways to decode it. Else 1 way

        for (int i = 2; i < table.length; i++) {
            if (input.charAt(i - 1) == '0' && input.charAt(i) == '0') {
                table[i] = 0;
            } else if (input.charAt(i - 1) == '0' && input.charAt(i) != '0') {
                table[i] = table[i - 1];
            } else if (input.charAt(i - 1) != '0' && input.charAt(i) == '0') {
                if (input.charAt(i - 1) == '2' || input.charAt(i - 1) == '1') {
                    table[i] = table[i - 2];
                } else {
                    table[i] = 0;
                }
            } else {
                if (Integer.parseInt(input.substring(i - 1, i + 1)) <= 26) {
                    table[i] = table[i - 1] + table[i - 2];
                } else {
                    table[i] = table[i - 1];
                }
            }
        }
        System.out.println(table[input.length() - 1]);

    }

//    public static void decode(String input, int startIndex, String decodedIntegerString) {
//
//        //Choose first digit
//        decode(input, startIndex + 1,  decodedIntegerString + );
//
//        //Choose first 2 digit's
//
//    }
}
