package com.santhosh.commonproblems;

import java.util.Scanner;

public class rotateDigits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int rotate = scn.nextInt();
        int numberOfDigits = countDigits(number);
        if(rotate < 0){
            rotate = rotate + numberOfDigits;
        }
        rotate = rotate % numberOfDigits;

        if(rotate != 0) {
            System.out.println(rotateDigits(number, rotate, numberOfDigits));
        }else {
            System.out.println(number);
        }
    }

    static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    static int rotateDigits(int number, int rotate, int numberOfDigits) {

        int div = 1;
        int mul = 1;
        for (int i=1; i<=numberOfDigits; i++){
            if(i<=rotate){
                div = div * 10;
            }else{
                mul = mul*10;
            }
        }
        int quotient = number / div;
        int remainder = number % div;
        //System.out.println("quotient: " + quotient);
        //System.out.println("remainder: " + remainder);
        number = quotient + remainder * mul;
        return number;
    }
}
