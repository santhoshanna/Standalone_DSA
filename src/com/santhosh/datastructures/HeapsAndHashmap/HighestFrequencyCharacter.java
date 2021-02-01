package com.santhosh.datastructures.HeapsAndHashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class HighestFrequencyCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }
        Set<Character> charKeySet = hm.keySet();
        char maxChar = 0;
        int maxValue = Integer.MIN_VALUE;
        for(char key: charKeySet){
            if(hm.get(key)> maxValue){
                maxValue = hm.get(key);
                maxChar = key;
            }
        }
        System.out.println(maxChar);
    }
}
