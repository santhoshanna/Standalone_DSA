package com.santhosh.recurssion.advancedbacktracking;

import java.util.Scanner;

public class JosephusProblem {

    //
    public static int solution(int n, int k) {
        //write your code here
        if (n == 1) {
            return 0;
        }
        int x = solution(n - 1, k);
        int y = (x + k) % n;
        return y;
    }

    //Iterative using circular linked list
    public static void getJosephus(int n, int k) {
        //write your code here
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i <= n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        temp.next = head;

        Node temp1 = head;
        Node temp2 = head;
        while (temp1.next != temp1) {
            //Find the kth person
            int count = 1;
            while (count != k) {
                temp2 = temp1;
                temp1 = temp1.next;
                count++;
            }
            temp2.next = temp1.next;
            temp1 = temp2.next;
        }
        System.out.println(temp1.data);
    }

    public static class Node {
        private int data;
        private Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class CircularLinkedList {
        private Node head;
        private Node tail;

        CircularLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            tail.next = head;
        }

        public boolean find(int value) {
            Node temp = head;
            if (head == null) {
                return false;
            }
            while (temp != null) {
                if (temp.data == value) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public void delete(int value) {
            Node node = new Node(value);
            if (head == null) {
                return;
            }
            Node temp = head;
            Node currentNode = head;
            while (temp != head) {
                currentNode = temp;
                if (temp.data == value) {
                    currentNode.next = temp.next;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public static CircularLinkedList createCircularLinkedList() {
        CircularLinkedList cll = new CircularLinkedList();

        cll.add(13);
        cll.add(7);
        cll.add(24);
        cll.add(1);
        cll.add(8);
        cll.add(37);
        cll.add(46);

        return cll;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
        getJosephus(n, k);
    }
}
