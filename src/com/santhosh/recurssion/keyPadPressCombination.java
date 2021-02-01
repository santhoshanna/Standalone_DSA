package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class keyPadPressCombination {
    static final String[] characterMap = {
            ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz",
    };

    public static void main(String[] args) throws Exception {


        Scanner scn = new Scanner(System.in);
        String sequence = scn.nextLine();

        ArrayList<String> list = kpc(sequence);
        System.out.println(list);
    }

    public static ArrayList<String> kpc(String sequence) {

        if (sequence.length() == 0) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
        char currentChar = sequence.charAt(0);
        ArrayList<String> subList = kpc(sequence.substring(1));

        ArrayList<String> consolidateList = new ArrayList<>();
        String code = characterMap[currentChar - '0'];
        for (int i = 0; i < code.length(); i++) {
            for (String item : subList) {
                consolidateList.add(code.charAt(i) + item);
            }
        }
        return consolidateList;
    }
}
