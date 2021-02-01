package com.santhosh.numbersystem;

import java.util.Scanner;

public class decimalConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(sum(n1, n2, b));
        System.out.println(subtract(n1, n2, b));
        System.out.println(multiply(n1, n2, b));
    }

    static int sum(int n1, int n2, int b) {
        int dec1 = anyBaseToDecimalConversion(n1, b);
        int dec2 = anyBaseToDecimalConversion(n2, b);
        return decimalToAnyBaseConversion(dec1 + dec2, b);
    }

    static int subtract(int n1, int n2, int b) {
        int dec1 = anyBaseToDecimalConversion(n1, b);
        int dec2 = anyBaseToDecimalConversion(n2, b);
        return decimalToAnyBaseConversion(dec1 - dec2, b);
    }

    static int multiply(int n1, int n2, int b) {
        int dec1 = anyBaseToDecimalConversion(n1, b);
        int dec2 = anyBaseToDecimalConversion(n2, b);
        return decimalToAnyBaseConversion(dec1 * dec2, b);
    }

    static int anyBaseToDecimalConversion(int n, int b) {
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

    static int decimalToAnyBaseConversion(int n, int base) {
        int number = 0;
        int remainder = 0;
        int count = 0;
        while (n != 0) {
            remainder = (n % base);
            number = number + remainder * (int) Math.pow(10, count);
            n = (n / base);
            count++;
        }
        return number;
    }
}
