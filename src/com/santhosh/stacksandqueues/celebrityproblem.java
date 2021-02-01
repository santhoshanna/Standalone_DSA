package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class celebrityproblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }


    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        while (stack.size() >= 2) {
            int person2 = stack.pop();
            int person1 = stack.pop();
            if (arr[person1][person2] == 1) {
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }
        int probableCelebrityIndex = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != probableCelebrityIndex) {
                if (arr[i][probableCelebrityIndex] == 0 || arr[probableCelebrityIndex][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(probableCelebrityIndex);
    }

    //Brute
    public static void findCelebrityBrute(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int[] celebrity = new int[arr.length];
        boolean[] celebrityBool = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0 && i != j) {
                    isCelebrity = false;
                }
            }
            if (isCelebrity) {
                celebrity[i] = i;
                celebrityBool[i] = isCelebrity;
            }
        }
        int sum = 0;
        for (int i = 0; i < celebrity.length; i++) {
            sum += celebrity[i];
            if (celebrityBool[i]) {
                System.out.println(celebrity[i]);
            }
        }
        if (sum == 0) {
            System.out.println("none");
        }
    }
}
