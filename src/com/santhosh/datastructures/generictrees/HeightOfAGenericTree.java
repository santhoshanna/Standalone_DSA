package com.santhosh.datastructures.generictrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class HeightOfAGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        // write your code here
        // int height = 0; // Depth In terms of Nodes
        int height = -1;
        for (Node child : node.children) {
            height = Math.max(height, height(child));
        }
        return height + 1;
    }

    public static void multisolver(Node node, int depth) {
        max = Math.max(node.data, max);
        min = Math.min(node.data, min);
        height = Math.max(height, depth);
        size++;

        for (Node child : node.children) {
            multisolver(child, depth + 1);
        }
    }

    private static int height = 0;
    private static int size = 0;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int h = height(root);
        System.out.println(h - 1);
        // display(root);


        multisolver(root, 0);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Size: " + size);
        System.out.println("Height: " + height);
    }
}
