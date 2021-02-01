package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePathsWithJumps {

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

        if ((sr == dr) && (sc == dc)) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        ArrayList<String> consolidatesList = new ArrayList<>();
        ArrayList<String> getSublistForH = new ArrayList<>();
        ArrayList<String> getSublistForL = new ArrayList<>();
        ArrayList<String> getSublistForD = new ArrayList<>();

        //horizontal move. Don't let it go beyond the border
            for (int h = 1; (h <= dc - sc); h++) {
                getSublistForH = getMazePaths(sr, sc + h, dr, dc);
                for (String steps : getSublistForH) {
                    consolidatesList.add("h" + h + steps);
                }
            }

        //Vertical move. Don't let it go beyond the border
            for (int v = 1; (v <= dr - sr); v++) {
                getSublistForL = getMazePaths(sr + v, sc, dr, dc);
                for (String steps : getSublistForL) {
                    consolidatesList.add("v" + v + steps);
                }
            }

        //Diagonal move. Don't let it go beyond the border
            for (int d = 1; (d <= dr - sr) && (d <= dc - sc); d++) {
                getSublistForD = getMazePaths(sr + d, sc + d, dr, dc);
                for (String steps : getSublistForD) {
                    consolidatesList.add("d" + d + steps);
                }
            }

        return consolidatesList;
    }
}
