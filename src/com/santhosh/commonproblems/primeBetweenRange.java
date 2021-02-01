package com.santhosh.commonproblems;

import java.util.Scanner;

public class primeBetweenRange {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        printPrime(low, high);

    }

    static void printPrime(int low, int high) {

        for (int div = low; div <= high; div++) {
            if (isPrimeEfficient(div)) {
                System.out.println(div);
            }
        }
    }

    static boolean isPrimeEfficient(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}
