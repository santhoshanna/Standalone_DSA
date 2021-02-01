package com.santhosh.datastructures.binarytree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MultiPurposeBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    //private static int size = 0;
    //private static int sum;
    //private static int max = Integer.MIN_VALUE;
    private static int height;

    public static int size(Node node) {
        // write your code here
        int size = 0;
        if (node == null) {
            return 0;
        }
        size += size(node.left);
        size += size(node.right);
        return size + 1;
    }

    public static int sum(Node node) {
        // write your code here
        int sum = 0;
        if (node == null) {
            return 0;
        }
        sum += sum(node.left);
        sum += sum(node.right);
        sum += node.data;
        return sum;
    }

    public static int max(Node node) {
        // write your code here
        int max = Integer.MIN_VALUE;
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        max = Math.max(max(node.left), max);
        max = Math.max(max(node.right), max);
        max = Math.max(node.data, max);
        return max;
    }

    public static int height(Node node) {
        // write your code here
        int height = 0;
        if (node == null) {
            return -1;
        }
        int heightl = height(node.left);
        int heightr = height(node.right);
        height = Math.max(heightl, heightr) + 1;

        return height;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        Node root = construct(arr);
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}
