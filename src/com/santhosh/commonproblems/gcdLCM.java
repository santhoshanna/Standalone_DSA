package com.santhosh.commonproblems;

import java.util.Scanner;

public class gcdLCM {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int gcd = gcd(a, b);
        int lcm = (a*b)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a > b) {
            return gcd(a-b, b);
        }else {
            return gcd(a, b-a);
        }
    }
}
