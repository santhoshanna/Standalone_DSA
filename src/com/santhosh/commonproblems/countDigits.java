package com.santhosh.commonproblems;

import java.util.Scanner;

public class countDigits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println(countDigits(number));
    }

    static int countDigits(int number) {
        int count =0;
        while(number!=0){
            number = number / 10;
            count++;
        }
        return count;
    }
}
