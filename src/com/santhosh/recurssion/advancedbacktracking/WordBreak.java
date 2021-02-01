package com.santhosh.recurssion.advancedbacktracking;

import java.util.HashSet;
import java.util.Scanner;

public class WordBreak {
    public static void solution(HashSet<String> dictionary, String sentence, String asf) {
        if (sentence.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < sentence.length(); i++) {
            String left = sentence.substring(0, i + 1);
            String right = sentence.substring(i + 1);
            if (dictionary.contains(left)) {
                solution(dictionary, right, asf + left + " ");
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dictionary = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(scn.next());
        }
        String sentence = scn.next();
        solution(dictionary, sentence, "");
    }
}
