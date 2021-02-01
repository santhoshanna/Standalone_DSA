package com.santhosh.datastructures.generictrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfAGenericTree {
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

    private static int diameter;

    public static int diameter(Node node) {

        int height1 = -1;
        int height2 = -1;

        for (Node child : node.children) {
            int childHeight = diameter(child);
            if (childHeight > height1) {
                height2 = height1;
                height1 = childHeight;
            } else if (childHeight > height2) {
                height2 = childHeight;
            }
        }

        if (height1 + height2 + 2 > diameter) {
            diameter = height1 + height2 + 2;
        }
        return height1 + 1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);
        diameter = 0;
        diameter(root);
        System.out.println(diameter);
        // write your code here
    }

}
