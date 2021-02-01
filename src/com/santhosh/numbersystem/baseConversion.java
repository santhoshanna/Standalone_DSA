package com.santhosh.numbersystem;

import java.util.Scanner;

public class baseConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(baseConversion(n,b));
    }
    static int baseConversion(int n, int base){
        int number = 0;
        int remainder = 0;
        int count = 0;
        while(n!=0){
            remainder = (n%base);
            number = number + remainder * (int)Math.pow(10, count);
            n = (n/base);
            count++;
        }
        return number;
    }
}
