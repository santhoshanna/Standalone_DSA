package com.santhosh.recurssion;

import java.util.Scanner;

public class zigzag {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.print(n + " ");
            pzz(n - 1);
            System.out.print(n + " ");
            pzz(n - 1);
            System.out.print(n + " ");
        }
    }
}
