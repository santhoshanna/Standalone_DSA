package com.santhosh.commonproblems;

import java.util.Scanner;

public class pythogoreanTriplet {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        if(a>b && a>c){
            if(a*a == (b*b) + (c*c)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }else if(b>a && b>c){
            if(b*b == (a*a) + (c*c)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }else if(c>a && c>b){
            if(c*c == (a*a) + (b*b)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }else{
            System.out.println(false);
        }
    }
}
