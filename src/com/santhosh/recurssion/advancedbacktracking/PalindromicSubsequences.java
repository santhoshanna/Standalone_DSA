package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class PalindromicSubsequences {

    public static void solution(String input, String asf) {
        if (input.length() == 0) {
            System.out.println(asf);
        }

        for (int i = 0; i < input.length(); i++) {
            String prefix = input.substring(0, i + 1);
            if (isPalindrome(prefix)) {
                // System.out.println(prefix);
                //System.out.println(asf + "(" + prefix + ")");
                solution(input.substring(i + 1), asf + "(" + prefix + ") ");
            }
        }
    }

    public static boolean isPalindrome(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            int i = 0;
            int j = input.length() - 1;
            while (i < j) {
                if (input.charAt(i) != input.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        solution(input, "");
    }
}
