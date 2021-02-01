package com.santhosh.datastructures.binarytree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestSubtreeBSTinaBT {
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

    public static class BST {
        private int size;
        private Node root;
        private int max;
        private int min;
        private boolean isBST;

        BST() {
            this.size = 0;
            this.root = null;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            isBST = true;
        }
    }

    public static BST findLargestSizedBSTinaBT(Node node) {
        if (node == null) {
            return new BST();
        }
        BST leftBST = findLargestSizedBSTinaBT(node.left);
        BST rightBST = findLargestSizedBSTinaBT(node.right);
        BST nodeBST = new BST();
        nodeBST.max = Math.max(node.data, Math.max(leftBST.max, rightBST.max));
        nodeBST.min = Math.max(node.data, Math.max(leftBST.min, rightBST.min));
        nodeBST.isBST = leftBST.isBST && rightBST.isBST && (node.data >= leftBST.max && node.data <= rightBST.min);
        if (nodeBST.isBST) {
            nodeBST.size = leftBST.size + rightBST.size + 1;
            nodeBST.root = node;
        } else if (leftBST.size > rightBST.size) {
            nodeBST.root = leftBST.root;
            nodeBST.size = leftBST.size;
        } else {
            nodeBST.root = rightBST.root;
            nodeBST.size = rightBST.size;
        }
        return nodeBST;
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
        BST bst = findLargestSizedBSTinaBT(root);
        System.out.println(bst.root.data + "@" + bst.size);
        // write your code here
    }

}
