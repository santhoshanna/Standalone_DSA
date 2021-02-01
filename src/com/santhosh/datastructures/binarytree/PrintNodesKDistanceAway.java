package com.santhosh.datastructures.binarytree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PrintNodesKDistanceAway {
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

    private static boolean nodeFound;

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        ArrayList<Node> path = nodeToRootPath(node, data);
        Node previous = path.get(0);
        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), k - i, previous);
            previous = path.get(i);
        }
    }

    private static ArrayList<Node> path = new ArrayList<>();

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        // write your code here


        if (node == null) {
            ArrayList<Node> base = new ArrayList<>();
            return base;
        }
        if (node.data == data) {
            path.add(node);
            return path;
        }
        path = nodeToRootPath(node.left, data);
        if (path.size() > 0) {
            path.add(node);
            return path;
        }

        path = nodeToRootPath(node.right, data);
        if (path.size() > 0) {
            path.add(node);
            return path;
        }
        return path;
    }

    public static Node leftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        Node left = leftClonedTree(node.left);
        Node right = leftClonedTree(node.right);

        Node newNode = new Node(node.data, left, null);
        node.left = newNode;
        node.right = right;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        // write your code here
        if (node.left != null && node.left == node) {
            Node temp = node.right;
            node = node.left;
            node.right = temp;
            return node;
        }
        Node leftCleanedUpNode = transBackFromLeftClonedTree(node.left);
        Node rightCleanedUpNode = transBackFromLeftClonedTree(node.right);
        node.left = leftCleanedUpNode;
        node.right = rightCleanedUpNode;

        return node;
    }

    public static void pathToLeafFromRootInRange(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.data <= hi && sum + node.data >= lo) {
                System.out.println(path + node.data + "");
                return;
            }
        }
        pathToLeafFromRootInRange(node.left, path + node.data + " ", sum + node.data, lo, hi);

        pathToLeafFromRootInRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static void printKLevelsDown(Node node, int k, Node block) {
        // write your code here
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        if (node.left != block) {
            printKLevelsDown(node.left, k - 1, block);
        }
        if (node.right != block) {
            printKLevelsDown(node.right, k - 1, block);
        }
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
        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }
}
