package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class WordPuzzle {

    public static void solution(char[][] arr, String[] words, int wordIndex) {
        //write your code here
        if (wordIndex == words.length) {
            print(arr);
            return;
        }
        String word = words[wordIndex];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    //Place horizontally if possible
                    if (canWePlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] charPlaced = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, wordIndex + 1);
                        unPlaceWordHorizontally(arr, word, i, j, charPlaced);
                    }//Place vertically if possible
                    else if (canWePlaceWordVertically(arr, word, i, j)) {
                        boolean[] charPlaced = placeWordVertically(arr, word, i, j);
                        solution(arr, words, wordIndex + 1);
                        unPlaceWordVertically(arr, word, i, j, charPlaced);
                    }
                }
            }
        }

    }

    private static boolean canWePlaceWordVertically(char[][] arr, String word, int i, int j) {

        if (i - 1 > 0 && (arr[i - 1][j] != '+')) {
            return false;
        } else if ((i + word.length() < arr.length) && (arr[i + word.length()][j] != '+')) {
            return false;
        }
        for (int row = i; row < i + word.length(); row++) {
            if (row <= arr.length - 1) {
                if (!(arr[row][j] == '-' || arr[row][j] == word.charAt(row - i))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canWePlaceWordHorizontally(char[][] arr, String word, int i, int j) {

        if ((j - 1 > 0) && (arr[i][j - 1] != '+')) {
            return false;
        } else if ((j + word.length() < arr[0].length) && (arr[i][j + word.length()] != '+')) {
            return false;
        }
        for (int col = j; col < j + word.length(); col++) {
            if (col <= arr[0].length - 1) {
                if (!(arr[i][col] == '-' || arr[i][col] == word.charAt(col - j))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] charPlaced = new boolean[word.length()];
        for (int col = j; col < j + word.length(); col++) {
            if (arr[i][col] == '-') {
                arr[i][col] = word.charAt(col - j);
                charPlaced[col - j] = true;
            }
        }
        return charPlaced;
    }

    private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] charPlaced = new boolean[word.length()];
        for (int row = i; row < i + word.length(); row++) {
            if (arr[row][j] == '-') {
                arr[row][j] = word.charAt(row - i);
                charPlaced[row - i] = true;
            }
        }
        return charPlaced;
    }

    private static void unPlaceWordHorizontally(char[][] arr, String word, int i, int j, boolean[] charPlaced) {
        for (int col = j; col < j + word.length(); col++) {
            if (charPlaced[col - j]) {
                arr[i][col] = '-';
            }
        }
    }

    private static void unPlaceWordVertically(char[][] arr, String word, int i, int j, boolean[] charPlaced) {
        for (int row = i; row < i + word.length(); row++) {
            if (charPlaced[row - i]) {
                arr[row][j] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);

    }
}
