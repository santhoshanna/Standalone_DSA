package com.santhosh.commonproblems;

import java.util.Scanner;

public class printFibonacci {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        printFibonacci(count);
    }

    static void printFibonacci(int count) {
        int num1 = 0;
        int num2 = 1;
        System.out.println(num1);
        System.out.println(num2);
        for (int i = 2; i < count; i++) {
            int sum = num1 + num2;
            System.out.println(sum);
            num1 = num2;
            num2 = sum;
        }
    }
}
