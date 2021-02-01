package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> list = getMazePaths(1, 1, n, m);
        System.out.println(list);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

//        if ((sr == dr) || (sc == dc)) {
//            ArrayList<String> baseList = new ArrayList<>();
//            baseList.add("");
//            return baseList;
//        }
        if ((sr == dr) && (sc == dc)) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        ArrayList<String> consolidatesList = new ArrayList<>();
        ArrayList<String> getSublistForH = new ArrayList<>();
        ArrayList<String> getSublistForL = new ArrayList<>();

        //horizontal move. Don't let it go beyond the border
        if ((sc < dc)) {
            getSublistForH = getMazePaths(sr, sc + 1, dr, dc);
        }

        //Vertical move. Don't let it go beyond the border
        if ((sr < dr)) {
            getSublistForL = getMazePaths(sr + 1, sc, dr, dc);
        }

        for (String steps : getSublistForH) {
            consolidatesList.add("h" + steps);
        }

        for (String steps : getSublistForL) {
            consolidatesList.add("v" + steps);
        }

        return consolidatesList;
    }
}
