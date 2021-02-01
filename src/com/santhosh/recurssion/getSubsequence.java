package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class getSubsequence {

    private Scanner scn;

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String sequence = scn.next();
        ArrayList<String> list = gss(sequence);
        System.out.println(list);
    }

    //Recursion
    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> blist = new ArrayList<>();
            blist.add("");
            return blist;
        }
        ArrayList<String> list = gss(str.substring(1));
        ArrayList<String> returnList = new ArrayList<>();
        for (String entry : list) {
            returnList.add("" + entry);
        }

        for (String entry : list) {
            returnList.add(str.charAt(0) + entry);
        }
        return returnList;
    }
//Regular method
//    public static ArrayList<String> gss(String str) {
//        int limit = (int) Math.pow(2, str.length());
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < limit; i++) {
//            int temp = i;
//            String s = "";
//            for (int j = str.length() - 1; j >= 0; j--) {
//                int remainder = temp % 2;
//                temp = temp / 2;
//                if (remainder != 0) {
//                    s = str.charAt(j) + s;
//                }
//            }
//            list.add(s);
//        }
//        return list;
//    }
}
