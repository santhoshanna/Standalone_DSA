package com.santhosh.recurssion;

import java.util.Scanner;

public class printMazePathsWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if ((sr == dr) && (sc == dc)) {
            System.out.println(psf);
            return;
        }
        //Horizontal move
        for (int h = 1; (h <= dc) && (sc + h <= dc); h++) {
            printMazePaths(sr, sc + h, dr, dc, psf + 'h' + h);
        }
        //Vertical move
        for (int v = 1; (v <= dr) && (v + sr <= dr); v++) {
            printMazePaths(sr + v, sc, dr, dc, psf + 'v' + v);
        }

        //diagonal move
        for (int d = 1; (d + sc <= dc) && (d + sr <= dr); d++) {
            printMazePaths(sr + d, sc + d, dr, dc, psf + 'd' + d);
        }
    }
}
