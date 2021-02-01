package com.santhosh.datastructures.generictrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PredecessorAndSuccessor {
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

    static Node predecessor;
    static Node successor;
    static boolean predecessorFound;
    static boolean successorFound;
    static int state;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (predecessorFound == true && successorFound == false) {
            successor = node;
            successorFound = true;
        } else if (node.data == data && predecessorFound == false && successorFound == false) {
            predecessor = node;
            predecessorFound = true;
        }
        // write your code here
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            if (predecessorFound == true) {
                successor = child;
                successorFound = true;
            } else if (child.data == data && predecessorFound == false && successorFound == false) {
                if (i - 1 >= 0) {
                    predecessor = node.children.get(i - 1);
                    predecessorFound = true;
                } else {
                    predecessor = node;
                    predecessorFound = true;
                }
                if (i + 1 < node.children.size() && predecessorFound == true && successorFound == false) {
                    successor = node.children.get(i + 1);
                    successorFound = true;
                }
            } else {
                predecessorAndSuccessor(child, data);
            }
        }
    }

    public static void predecessorAndSuccessorAnother(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        // write your code here
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            predecessorAndSuccessorAnother(child, data);
        }
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
        predecessor = null;
        successor = null;
        predecessorAndSuccessorAnother(root, data);
        if (predecessor == null) {
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predecessor.data);
        }

        if (successor == null) {
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }
    }

}
