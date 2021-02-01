package com.santhosh.datastructures.BST;

public class BSTImplementation {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        Node() {
            this.left = null;
            this.right = null;
            this.data = 0;
        }

        Node(int data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
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

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        Node root = new Node();
        root.data = arr[mid];

        root.left = construct(arr, lo, mid - 1);
        root.right = construct(arr, mid + 1, hi);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }

}
