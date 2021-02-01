package com.santhosh.recurssion.advancedbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine2 {
    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        //write your code here
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (visited[i][j] == false && arr[i][j] != 0) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    getMaxGoldFromAnIsland(arr, i, j, visited, bag);
                    int sum = 0;
                    for (int gold : bag) {
                        sum += gold;
                    }
                    max = Math.max(sum, max);
                }
            }
        }
    }

    public static void getMaxGoldFromAnIsland(int[][] arr, int row, int col, boolean[][] visited, ArrayList<Integer> bag) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 0 || visited[row][col] == true) {
            return;
        }

        visited[row][col] = true;
        bag.add(arr[row][col]);
        //Top travel
        getMaxGoldFromAnIsland(arr, row - 1, col, visited, bag);

        //Right travel
        getMaxGoldFromAnIsland(arr, row, col + 1, visited, bag);

        //Left travel
        getMaxGoldFromAnIsland(arr, row, col - 1, visited, bag);

        //Bottom travel
        getMaxGoldFromAnIsland(arr, row + 1, col, visited, bag);
        //visited[row][col] = false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }
}
