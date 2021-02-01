package com.santhosh.commonproblems;

import java.util.Scanner;

public class reverseDigits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        reverseDigits(number);
    }

    static void reverseDigits(int number) {
        while(number!=0) {
            System.out.println(number % 10);
            number = number / 10;
        }

    }
}
