package com.santhosh.string;

import java.util.Scanner;

public class palindromicSubstring {

    public static boolean isPalindrome(char[] array) {
        boolean isPalindrome = true;

        for (int k = 0; k < array.length; k++) {
            if (array[k] != array[array.length - 1 - k]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if (ch1 != ch2) {
                isPalindrome = false;
                break;
            } else {
                i++;
                j--;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        //System.out.println("Length: " + s.length());

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j).toCharArray())) {
                    System.out.println(s.substring(i, j));
                }
            }
        }
    }
}
