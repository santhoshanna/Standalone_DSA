package com.santhosh.commonproblems;

import java.util.*;

public class isPrime{

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
        }return true;

    }

    static boolean isPrimeEfficient(int n){
        if(n<=1){
            return false;
        }else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
        }return true;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        for(int i=0; i<t; i++){
            int n = scn.nextInt();
            if(isPrimeEfficient(n)){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
        }

    }

}
