package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (visited[i][j] == false && arr[i][j] == 0) {
                    ArrayList<String> comp = new ArrayList<>();
                    findIslands(arr, i, j, visited, comp);
                    System.out.println(comp);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void findIslands(int[][] arr, int row, int col, boolean[][] visited, ArrayList<String> comp) {
        //base case
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 1 || visited[row][col] == true) {
            return;
        }

        visited[row][col] = true;
        comp.add(row + "-" + col);
        //travel top
        findIslands(arr, row - 1, col, visited, comp);

        //travel left
        findIslands(arr, row, col - 1, visited, comp);

        //travel down
        findIslands(arr, row + 1, col, visited, comp);

        //travel right
        findIslands(arr, row, col + 1, visited, comp);
    }
}
