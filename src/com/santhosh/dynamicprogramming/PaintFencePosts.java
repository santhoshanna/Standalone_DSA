package com.santhosh.dynamicprogramming;

import java.util.Scanner;

public class PaintFencePosts {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(k);
            return;
        }

        long same = k;
        long different = k * (k - 1);
        long total = same + different;

        for (int i = 3; i <= n; i++) {
            same = different;
            different = (total) * (k - 1);
            total = same + different;
        }
        System.out.println(total);
    }
}
