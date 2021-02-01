package com.santhosh.stringbuilder;

import java.util.Scanner;

public class printPermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int factorial = factorial(str.length());

        for (int i = 0; i < factorial; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for (int div = str.length(); div > 0; div--) {
                int quotient = temp / div;
                int remainder = temp % div;
                System.out.print(sb.charAt(remainder));
                sb.deleteCharAt(remainder);
                temp = quotient;
            }
            System.out.println();
        }
    }

    public static int factorial(int n) {
        // write your code here
        int val = 1;
        for (int i = 1; i <= n; i++) {
            val *= i;
        }
        return val;
    }
}
