package com.santhosh.OOP;

public class Experiment {
    public static void main(String[] args) {
        Person person1 = new Person("Santosh", "UP");
        Person person2 = new Person("Dhanya", "UP");

        //If -ve, then person1 is ascending order wise after person2
        System.out.println("Comparing both: " + person1.compareTo(person2));
    }
}
