package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class APlusBPlusCPlusSequenceCount {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();

        int a = 0;
        int aPlusb = 0;
        int aPlusbPlusc = 0;

        for (int i = 0; i <= input.length() - 1; i++) {
            char ch = input.charAt(i);

            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                aPlusb = 2 * aPlusb + a;
            } else if (ch == 'c') {
                aPlusbPlusc = 2 * aPlusbPlusc + aPlusb;
            }
        }
        System.out.println(aPlusbPlusc);
    }
}
