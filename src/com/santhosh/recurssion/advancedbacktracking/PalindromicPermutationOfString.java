package com.santhosh.recurssion.advancedbacktracking;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromicPermutationOfString {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character odd, String asf) {
        if (cs > ts) {
            //System.out.println(fmap);
            // System.out.println(asf);
            String reverse = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                reverse += asf.charAt(i);
            }
            //System.out.println(reverse);
            String res = asf;
            if (odd != null) {
                res += odd;
            }
            //System.out.println(res);
            res += reverse;
            System.out.println(res);
            return;
        }

        //Append character from the map at the index in to the string recursively
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            //System.out.println(fmap);
            if (freq > 0) {
                //System.out.println("Recursion for map entry: " + ch);
                //System.out.println("Recursion for map entry: " + ch);
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, odd, asf + ch);
                fmap.put(ch, freq);
            }
        }

    }

    public static String reverse(String input) {
        if (input.length() == 1) {
            return input;
        } else {
            return input.charAt(input.length() - 1) + reverse(input.substring(1));
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        //Capture the frequency map for the string
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        //Capture the lengths
        int originalLength = str.length();
        int halvedLength = 0;

        //Capture the odd character details
        Character odd = null;
        int oddc = 0;


        //Half the frequency map
        for (char ch : fmap.keySet()) {
            int freqOfCurrentChar = fmap.get(ch);
            //System.out.println("character: " + ch + " original frequency: " + freqOfCurrentChar);

            //Is character freq odd? It can only be one
            if (freqOfCurrentChar % 2 == 1) {
                if (odd != null) {
                    System.out.println(-1);
                    return;
                } else {
                    odd = ch;
                    oddc++;
                }
            }

            fmap.put(ch, freqOfCurrentChar / 2);
            //System.out.println("character: " + ch + " modified frequency: " + freqOfCurrentChar / 2);
            //System.out.println(odd);
            halvedLength += freqOfCurrentChar / 2;
        }

        generatepw(1, halvedLength, fmap, odd, "");
    }
}
