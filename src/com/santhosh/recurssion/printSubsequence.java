package com.santhosh.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class printSubsequence {

    private Scanner scn;

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String sequence = scn.next();
        gss(sequence, "");
    }

    //Recursion
    public static void gss(String question, String answer) {
        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }
        gss(question.substring(1), answer + question.charAt(0));
        gss(question.substring(1), answer + "");
    }
}
