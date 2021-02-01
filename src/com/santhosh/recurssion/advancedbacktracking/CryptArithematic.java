package com.santhosh.recurssion.advancedbacktracking;

import java.util.HashMap;
import java.util.Scanner;

public class CryptArithematic {
    public static int val(String s, HashMap<Character, Integer> charIntMap) {
        String intInTermsOfString = "";
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int val = charIntMap.get(key);
            intInTermsOfString += val;
        }
        return Integer.parseInt(intInTermsOfString);
    }

    public static void solution(String unique, int idx,
                                HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                                String s1, String s2, String s3) {
        // write your code here
        if (idx == unique.length()) {
            if (val(s1, charIntMap) + val(s2, charIntMap) == val(s3, charIntMap)) {
                for (int i = 0; i < 26; i++) {
                    char key = (char) ('a' + i);
                    if (charIntMap.containsKey(key)) {
                        System.out.print(key + "-" + charIntMap.get(key) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        //Lets consider first digit in the hashmap
        char key = unique.charAt(idx);
        for (int num = 0; num < 10; num++) {
            if (usedNumbers[num] == false) {
                charIntMap.replace(key, num);
                usedNumbers[num] = true;
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                charIntMap.replace(key, -1);
                usedNumbers[num] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            if (!charIntMap.containsKey(key)) {
                charIntMap.put(key, -1);
                unique += key;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            if (!charIntMap.containsKey(key)) {
                charIntMap.put(key, -1);
                unique += key;
            }
        }
        for (int i = 0; i < s3.length(); i++) {
            char key = s3.charAt(i);
            if (!charIntMap.containsKey(key)) {
                charIntMap.put(key, -1);
                unique += key;
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }
}
