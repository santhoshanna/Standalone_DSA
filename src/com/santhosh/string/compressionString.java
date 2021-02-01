package com.santhosh.string;

import java.util.Scanner;

public class compressionString {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(firstLevelCompression(s));
        System.out.println(secondLevelCompression(s));
    }

    public static String firstLevelCompression(String s) {

        String newString = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            char previous = s.charAt(i - 1);
            if (previous == current) {
            } else {
                newString += current;
            }
        }
        return newString;
    }

    public static String secondLevelCompression(String s) {
        int counter = 1;
        String newString = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            char previous = s.charAt(i - 1);
            if (previous == current) {
                counter++;
            } else {
                if (counter != 1) {
                    newString += counter;
                    counter = 1;
                }
                newString += current;
            }
        }
        if(counter > 1){
            newString += counter;
        }
        return newString;
    }
}
