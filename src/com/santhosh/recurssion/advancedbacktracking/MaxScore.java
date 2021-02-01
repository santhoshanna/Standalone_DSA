package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class MaxScore {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        //write your code here
        if (idx == words.length) {
            return 0;
        }
        //Without including the word
        int scoreWithoutIncludingWord = solution(words, farr, score, idx + 1);

        //Including the word
        int scoreIncludingWord = 0;
        int scoreIncludingWordTemp = 0;
        boolean frequencyAvailable = true;
        String word = words[idx];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (farr[ch - 'a'] == 0) {
                frequencyAvailable = false;
            }
            farr[ch - 'a']--;
            scoreIncludingWordTemp += score[ch - 'a'];
        }
        if (frequencyAvailable) {
            scoreIncludingWord = scoreIncludingWordTemp + solution(words, farr, score, idx + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }

        return Math.max(scoreWithoutIncludingWord, scoreIncludingWord);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null ||
                score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
