package com.santhosh.pattern;

import java.util.Scanner;

public class pattern1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i=1; i<=n; i++){
            if(i<=(n/2)) {
                for (int j = 1; j < (n/2); j++) {
                    System.out.print("\t");
                }
                for (int k = 1; k <= (n/2); ) {
                    System.out.print("*\t");
                    k = k + 2;
                }
                for (int l = 1; l < (n/2); l++) {
                    System.out.print("\t");
                }
            }else{
                for (int j = 1; j < (n/2); j++) {
                    System.out.print("\t");
                }
                for (int k = n/2; k >= 1; ) {
                    System.out.print("*\t");
                    k = k - 2;
                }
                for (int l = 1; l < (n/2); l++) {
                    System.out.print("\t");
                }

            }
            System.out.println("");
        }
    }
}
