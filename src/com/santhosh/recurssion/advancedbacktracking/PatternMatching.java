package com.santhosh.recurssion.advancedbacktracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PatternMatching {

    public static void solution(String str, String pattern, HashMap<Character, String> patternMap, String original) {
        if (pattern.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < original.length(); i++) {
                    char ch = original.charAt(i);
                    if (alreadyPrinted.contains(ch) == false) {
                        alreadyPrinted.add(ch);
                        System.out.print(ch + " -> " + patternMap.get(ch) + ", ");
                    }
                }
                System.out.println(".");
            }
            return;
        }

//        for (int i = 0; i < str.length(); i++) {
//            if (!patternMap.containsKey(pattern.charAt(level))) {
//                patternMap.put(pattern.charAt(level), str.substring(0, i + 1));
//            } else {
//                if (patternMap.get(pattern.charAt(level)) == str.substring(0, i + 1)) {
//                    break;
//                }
//            }
//            solution(str.substring(i + 1), pattern.substring(1), patternMap,  original, level + 1);
//            patternMap.remove(pattern.charAt(level));
//        }
        char currentPatternCharacter = pattern.charAt(0);
        String restOfPattern = pattern.substring(1);
        if (patternMap.containsKey(currentPatternCharacter)) {
            String previousMapping = patternMap.get(currentPatternCharacter);
            if (str.length() >= previousMapping.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());
                if (left.equals(previousMapping)) {
                    solution(right, restOfPattern, patternMap, original);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                patternMap.put(currentPatternCharacter, left);
                solution(right, restOfPattern, patternMap, original);
                patternMap.remove(currentPatternCharacter);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character, String> patternMap = new HashMap<>();
        solution(str, pattern, patternMap, pattern);
    }
}
