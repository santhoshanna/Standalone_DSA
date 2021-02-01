package com.santhosh.recurssion;

import java.util.Scanner;

public class towerOfHanoi {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        int[] t = new int[n];
//        for (int i = 0; i < n; i++) {
//            t[i] = scn.nextInt();
//        }
        int th1 = scn.nextInt();
        int th2 = scn.nextInt();
        int th3 = scn.nextInt();
        toh(n, th1, th2, th3);
    }

    public static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        toh(n - 1, t3id, t2id, t1id);
    }
}
