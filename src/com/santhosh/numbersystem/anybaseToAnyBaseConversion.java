package com.santhosh.numbersystem;

import java.util.Scanner;

public class anybaseToAnyBaseConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        int decimal = decimalConversion( n, b1);
        System.out.println(baseConversion(decimal, b2));
    }
    static int baseConversion(int n, int b2){
        int number = 0;
        int remainder = 0;
        int count = 0;
        while(n!=0){
            remainder = (n%b2);
            number = number + remainder * (int)Math.pow(10, count);
            n = (n/b2);
            count++;
        }
        return number;
    }

    static int decimalConversion(int n, int b) {
        int count = 0;
        int digit = 0;
        int number = 0;
        while (n != 0) {
            digit = (n % 10);
            number += digit * (int) Math.pow(b, count);
            count++;
            n = (n / 10);
        }
        return number;
    }
}
