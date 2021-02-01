package com.santhosh.commonproblems;

import java.util.Scanner;

public class primeFactorisation {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
            for (int div = 2; ((div <= Math.sqrt(n)) || (n != 1)); div++) {
                while (n % div == 0) {
                    System.out.print(div);
                    n = n / div;
                }
        }
    }
}
