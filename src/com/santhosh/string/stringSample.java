package com.santhosh.string;

import java.util.Scanner;

public class stringSample {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        System.out.println("Length: " + s.length());

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.print(s.substring(i, j) + "\t");
            }
            System.out.println("");
        }
    }
}
