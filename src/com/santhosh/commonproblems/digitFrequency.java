package com.santhosh.commonproblems;

import java.util.Scanner;

public class digitFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        System.out.println(frequency(n,d));
    }
    static int frequency(int n, int d){
        int frq = 0;
        while(n!=0){
            if((n%10) ==d){
                frq++;
            }
            n = n / 10;
        }
        return frq;
    }
}
