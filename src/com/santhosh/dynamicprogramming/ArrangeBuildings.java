package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();

        long previousBsCount = 1;
        long previousSsCount = 1;

        long currentBsCount = 0;
        long currentSsCount = 0;

        for (int i = 2; i <= n; i++) {
            currentBsCount = previousSsCount;
            currentSsCount = previousSsCount + previousBsCount;

            previousSsCount = currentSsCount;
            previousBsCount = currentBsCount;
        }
        System.out.println((currentSsCount + currentBsCount) * (currentSsCount + currentBsCount));
    }
}
