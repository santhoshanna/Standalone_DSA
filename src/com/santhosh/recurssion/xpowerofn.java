package com.santhosh.recurssion;

import java.util.Scanner;

public class xpowerofn {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int start = (int) System.currentTimeMillis();
        System.out.println(power(x, n));
        int end = (int) System.currentTimeMillis();
        System.out.println(end - start);

//        start = (int) System.currentTimeMillis();
//        System.out.println(logpower(x, n));
//        end = (int) System.currentTimeMillis();
//        System.out.println(end - start);
    }

//    public static int power(int x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        return x * power(x, n - 1);
//    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);
        } else {
            return x * power(x, (n - 1) / 2) * power(x, (n - 1) / 2);
        }
    }
}
