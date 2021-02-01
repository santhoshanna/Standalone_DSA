package com.santhosh.datastructures.binarytree;

import com.santhosh.datastructures.generictrees.AreStreesMirrorImageOfEachOther;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryTreeImplementation {

    public static class Node {
        private int data;
        private Node right;
        private Node left;

        Node() {
            this.data = 0;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

    public static class Pair {
        private Node node;
        private int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <-- " + node.data + " --> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node construct(Integer[] arr) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair pair = new Pair(root, 1);
        st.push(pair);
        int i = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                i++;
                if (arr[i] != null) {
                    top.node.left = new Node(arr[i], null, null);
                    Pair pairlp = new Pair(top.node.left, 1);
                    st.push(pairlp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                i++;
                if (arr[i] != null) {
                    top.node.right = new Node(arr[i], null, null);
                    Pair pairp = new Pair(top.node.right, 1);
                    st.push(pairp);
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

    public static void main(String[] args) throws IOException {
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
        display(root);
    }
}
