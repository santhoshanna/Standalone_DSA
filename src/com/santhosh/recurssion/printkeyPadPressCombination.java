package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class printkeyPadPressCombination {
    static final String[] characterMap = {
            ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz",
    };

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String sequence = scn.nextLine();
        kpc(sequence, "");
    }

    public static void kpc(String sequence, String combination) {

        if (sequence.length() == 0) {
            System.out.println(combination);
            return;
        }
        char currentChar = sequence.charAt(0);
        String code = characterMap[currentChar - '0'];
        for (int i = 0; i < code.length(); i++) {
            kpc(sequence.substring(1), combination + code.charAt(i));
        }
    }
}
