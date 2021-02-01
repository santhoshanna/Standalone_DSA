package com.santhosh.commonproblems;

import java.util.Scanner;

public class printDigits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int count = countDigits(number);
        printDigits(count, number);
    }

    static int countDigits(int number) {
        int count =0;
        while(number!=0){
            number = number / 10;
            count++;
        }
        return count;
    }

    static void printDigits(int count, int number) {
        while(count!=0){
            System.out.println(Math.pow(10, count-1));
            System.out.println((int)(number / (Math.pow(10, count-1))));
            number = (int) (number % (Math.pow(10, count-1)));
            count--;
        }
    }
}
