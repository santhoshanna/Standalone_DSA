package com.santhosh.recurssion.backtrackking;

import java.util.Scanner;

public class floodfill {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = Integer.parseInt(scn.next());
            }
        }

//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                System.out.print(maze[i][j] + " ");
//            }
//            System.out.println("");
//        }

        floodfill(maze, 0, 0, "", new boolean[n][m]);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        //System.out.println("In flood fill loop");
        int rowmin = 0;
        int rowmax = maze.length - 1;
        int colmin = 0;
        int colmax = maze[0].length - 1;
        //base
        if ((row == rowmax) && (col == colmax)) {
            System.out.println(psf);
            return;
        }

        //top
        if ((row > rowmin) && (maze[row][col] != 1) && (visited[row - 1][col] != true)) {
            //System.out.println("Checking if we can navigate to the row above");
            visited[row][col] = true;
            floodfill(maze, row - 1, col, psf + 't', visited);
            visited[row][col] = false;
        }

        //left
        if ((col > colmin) && (maze[row][col] != 1) && (visited[row][col - 1] != true)) {
            //System.out.println("Checking if we can navigate to the col left of current col");
            visited[row][col] = true;
            floodfill(maze, row, col - 1, psf + 'l', visited);
            visited[row][col] = false;
        }

        //down
        if ((row < rowmax) && (maze[row][col] != 1) && (visited[row + 1][col] != true)) {
            //System.out.println("Checking if we can navigate to the row below");
            visited[row][col] = true;
            floodfill(maze, row + 1, col, psf + 'd', visited);
            visited[row][col] = false;
        }

        //right
        if ((col < colmax) && (maze[row][col] != 1) && (visited[row][col + 1] != true)) {
            //System.out.println("Checking if we can navigate to the col right of current col");
            visited[row][col] = true;
            floodfill(maze, row, col + 1, psf + 'r', visited);
            visited[row][col] = false;
        }
    }
}
