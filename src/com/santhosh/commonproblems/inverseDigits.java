package com.santhosh.commonproblems;

import java.util.Scanner;

public class inverseDigits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println(inverseDigits(number));
    }

    static int inverseDigits(int number) {
        int remainder = 0;
        int inversedNumber = 0;
        int position = 1;
        while (number != 0) {
            remainder = number % 10;
            inversedNumber = inversedNumber + position * (int) (Math.pow(10, remainder - 1));
            //System.out.println(inversedNumber);
            number = number / 10;
            position++;
        }
        return inversedNumber;
    }
}
