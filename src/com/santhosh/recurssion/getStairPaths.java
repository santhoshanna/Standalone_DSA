package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class getStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> list = getStairPaths(n);
        System.out.println(list);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }
//        if (n < 0) {
//            ArrayList<String> baseList = new ArrayList<>();
//            baseList.add("");
//            return baseList;
//        }

        ArrayList<String> ConsolidatedList = new ArrayList<>();

        //Step 1
//        if (!(n - 1 < 0)) {
//            ArrayList<String> subListForStep1 = getStairPaths(n - 1);
//            for (String item : subListForStep1) {
//                ConsolidatedList.add(1 + item);
//            }
//        }
//
//        //Step 2
//        if (!(n - 2 < 0)) {
//            ArrayList<String> subListForStep2 = getStairPaths(n - 2);
//            for (String item : subListForStep2) {
//                ConsolidatedList.add(2 + item);
//            }
//        }
//
//        //Step 3
//        if (!(n - 3 < 0)) {
//            ArrayList<String> subListForStep3 = getStairPaths(n - 3);
//            for (String item : subListForStep3) {
//                ConsolidatedList.add(3 + item);
//            }
//        }

        //n - i >= 0 ensures that there is no negative jump towards the end. i increments by 1 as the person can step into next stair by 1 count upto 3..
        for (int i = 1; i <= 3 && (n - i >= 0); i++) {
            ArrayList<String> subList = getStairPaths(n - i);
            for (String item : subList) {
                ConsolidatedList.add(i + item);
            }
        }

        return ConsolidatedList;
    }
}
