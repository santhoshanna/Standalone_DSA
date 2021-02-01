package com.santhosh.arraylist;

import java.util.Scanner;
import java.util.*;

public class removePrimesArraylist {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(scn.next()));
        }
        for (int i = al.size() - 1; i >= 0; i--) {
            if (isPrime(al.get(i))) {
                al.remove(i);
            }
        }
        System.out.println(al);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
