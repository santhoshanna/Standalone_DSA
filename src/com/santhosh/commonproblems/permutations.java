package com.santhosh.commonproblems;

import java.util.Scanner;

public class permutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        System.out.println(factorial(n)/(factorial(n-r)));




    }
    static int factorial(int n){
        int factorial = 1;
        for(int i=1; i<=n; i++){
            factorial*=i;
        }
        return factorial;
    }
}
