package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class LargestNumberWithUtmostKSwaps {
    private static String max;

//    public static String swap(String str, int i, int j) {
//        System.out.println(str);
//        char[] chArray = str.toCharArray();
//        char temp = chArray[i];
//        chArray[i] = chArray[j];
//        chArray[j] = temp;
//        System.out.println(chArray.toString());
//        return chArray.toString();
//    }

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);

        return left + jth + middle + ith + right;
    }

    public static void solution(String str, int k) {
        if (k == 0) {
            return;
        }
        if (Integer.parseInt(max) < Integer.parseInt(str)) {
            max = str;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);
                    solution(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        solution(str, k);
        System.out.println(max);
    }
}
