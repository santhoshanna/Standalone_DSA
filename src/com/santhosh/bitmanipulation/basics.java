package com.santhosh.bitmanipulation;

import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        //mask for OR operation for turning ON a bit
        int onmask = (1 << i);
        System.out.println(n | onmask);

        //mask for AND operation
        int offmask = ~(1 << j);
        System.out.println(n & offmask);

        //mask for toggling a bit using XOR operation
        int xormask = (1 << k);
        System.out.println(n ^ xormask);

        //mask for checking the value on mth bit
        int checkmask = (1 << m);
        System.out.println((n & checkmask) == 0 ? false : true);
    }
}
