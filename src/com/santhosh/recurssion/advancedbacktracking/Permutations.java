package com.santhosh.recurssion.advancedbacktracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Permutations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];

        printPermutations(boxes, r, 1);
    }

    public static void printPermutations(int[] boxes, int items, int currentLevel) {
        if (currentLevel > items) {
            for (int entry : boxes) {
                System.out.print(entry);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentLevel;
                printPermutations(boxes, items, currentLevel + 1);
                boxes[i] = 0;
            }
        }
    }
}
