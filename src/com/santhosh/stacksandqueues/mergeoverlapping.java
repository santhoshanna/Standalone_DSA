package com.santhosh.stacksandqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class mergeoverlapping {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        mergeOverlappingIntervals(arr);
    }

    public static class Pair implements Comparable<Pair> {
        private int st;
        private int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getEt() {
            return et;
        }

        public void setEt(int et) {
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "st=" + st +
                    ", et=" + et +
                    '}';
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        //sort the array using classes
        Arrays.sort(pairs);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(pairs[i]);
//        }
        //
        Stack<Pair> stack = new Stack<>();
        stack.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            Pair top = stack.peek();
            if (top.et < pairs[i].st) {
                stack.push(pairs[i]);
            } else {  //Merge case
                if (top.et < pairs[i].et) {
                    top.et = pairs[i].et;
                }
            }
        }
        Stack<Pair> reverseStack = new Stack<>();
        while (stack.size() != 0) {
            reverseStack.push(stack.pop());
        }

        while (reverseStack.size() != 0) {
            Pair pair = reverseStack.pop();
            System.out.println(pair.st + " " + pair.et);
        }
    }
}
