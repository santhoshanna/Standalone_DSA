package com.santhosh.datastructures.generictrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class NodeToRootPathGenericTree {
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

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Integer> list) {
        // write your code here
        if (node.data == data) {
            return true;
            //return list;
        }
        for (Node child : node.children) {
            boolean found = nodeToRootPath(child, data, list);
            if (found) {
                list.add(child.data);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        // write your code here
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(data);
            return list;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Node child : node.children) {
            list = nodeToRootPath(child, data);
            if (list != null && list.size() > 0) {
                list.add(node.data);
                return list;
            }
        }
        // list.add(node.data);
        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
//        ArrayList<Integer> list = new ArrayList<>();
//        nodeToRootPath(root, data, list);
        //       System.out.println(list);
        ArrayList<Integer> list = nodeToRootPath(root, data);
        System.out.println(list);
        // display(root);
    }

}
