package com.santhosh.recurssion;

import java.util.Scanner;

public class printEncodings {
    // private static final char[] encodings = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printEncodings(scn.nextLine(), "");
    }

    public static void printEncodings(String str, String answer) {

        if (str.length() == 0) {
            System.out.println(answer);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            int chv = ch - '0';
            if (chv == 0) {
                return;
            } else if (chv < 26 && chv != 0) {
                char code = (char) (chv + 'a' - 1);
                System.out.println(answer + code);
                return;
            }

        } else {
            //First digit
            char ch = str.charAt(0);
            int chv = ch - '0';
            if (chv == 0) {
                return;
            } else if (chv <= 26 && chv != 0) {
                char code = (char) (chv + 'a' - 1);
                //System.out.println("ch: " + ch + " chv: " + chv + " code: " + code);
                printEncodings(str.substring(1), answer + code);
            }

            //Try 2 digits
            String sub = str.substring(0, 2);
            int chv2 = Integer.parseInt(sub);
            if (chv2 <= 26 && chv2 != 0) {
                char code2 = (char) (chv2 + 'a' - 1);
                //System.out.println("sub: " + sub + " chv2: " + chv2 + " code2: " + code2);
                printEncodings(str.substring(2), answer + code2);
            }
        }
    }
}
