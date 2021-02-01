package com.santhosh.recurssion.advancedbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAbbreviations {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();

        subsequences(input, "", 0);
    }

    public static void subsequences(String input, String psf, int count) {
        if (input.length() == 0) {

            if (count == 0) {
                System.out.println(psf);
            } else {
                System.out.println(psf + count);
            }
            return;
        }

        subsequences(input.substring(1), count != 0 ? (psf + count + input.charAt(0)) : psf + input.charAt(0), 0);
        subsequences(input.substring(1), psf, count + 1);
    }
}
