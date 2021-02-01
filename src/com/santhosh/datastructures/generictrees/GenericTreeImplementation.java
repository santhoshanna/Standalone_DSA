package com.santhosh.datastructures.generictrees;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeImplementation {

    private static class Node {
        int data;
        ArrayList<Node> children;

        Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static void display(Node node) {
        if (node.children == null) {
            return;
        }
        String str = node.data + " --> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        for (Node child : node.children) {
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0) {
                root = new Node(arr[i]);
                stack.add(root);
            } else {
                if (arr[i] == -1) {
                    stack.pop();
                } else {
                    Node parent = stack.peek();
                    Node child = new Node(arr[i]);
                    parent.children.add(child);
                    stack.push(child);
                }
            }
        }
        display(root);
    }
}
