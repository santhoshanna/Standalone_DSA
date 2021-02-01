package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class PairOfFriends {
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        // write your code here
        if (i > n) {
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }
        if (used[i] == true) {
            solution(i + 1, n, used, asf);
            return;
        }
        //Without considering i. That is i decides to go solo.
        used[i] = true;
        solution(i + 1, n, used, asf + "(" + i + ") ");

        //Considering i. That is i decides to pair up.
        for (int j = i + 1; j <= n; j++) {
            if (used[j] == false) {
                used[j] = true;
                solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                used[j] = false;
            }
        }
        used[i] = false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }
}
