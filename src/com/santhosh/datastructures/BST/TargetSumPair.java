package com.santhosh.datastructures.BST;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TargetSumPair {
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

    public static Node inorderTraversal(Stack<Pair> stack) {
        while (stack.size() != 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
                top.state++;
            } else if (top.state == 2) {
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
                top.state++;
                return top.node;
            } else {
                stack.pop();
            }
        }
        return null;
    }

    public static Node reverseInorderTraversal(Stack<Pair> stack) {
        while (stack.size() != 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
                top.state++;
            } else if (top.state == 2) {
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
                top.state++;
                return top.node;
            } else {
                stack.pop();
            }
        }
        return null;
    }

    public static void traversalAlternate2(Node node, int target) {
        Stack<Pair> inOrderTravelStack = new Stack<>();
        inOrderTravelStack.add(new Pair(node, 1));

        Stack<Pair> reverseInOrderTravelStack = new Stack<>();
        reverseInOrderTravelStack.add(new Pair(node, 1));

        Node left = inorderTraversal(inOrderTravelStack);
        Node right = reverseInorderTraversal(reverseInOrderTravelStack);
        while (left.data < right.data) {
            if (left.data + right.data < target) {
                left = inorderTraversal(inOrderTravelStack);
            } else if (left.data + right.data > target) {
                right = reverseInorderTraversal(reverseInOrderTravelStack);
            } else {
                System.out.println(left.data + " " + right.data);
                left = inorderTraversal(inOrderTravelStack);
                right = reverseInorderTraversal(reverseInOrderTravelStack);
            }
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

    public static void traversal(Node root, Node node, int target) {
        if (node == null) {
            return;
        }
        traversal(root, node.left, target);
        int compensate = target - node.data;
        if (node.data < compensate) {
            if (find(root, compensate)) {
                System.out.println(node.data + " " + compensate);
            }
        }
        traversal(root, node.right, target);

    }

    public static void traversalAlternate(Node node, ArrayList list) {
        if (node == null) {
            return;
        }
        traversalAlternate(node.left, list);
        list.add(node.data);
        traversalAlternate(node.right, list);
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

//    @Test
//    public void test_find() {
//        Integer[] arr = {12, 25, 37, 50, 62, 75, 87};
//        Node root = construct(arr);
//        assertEquals("This is the testcase in this class", str1);
//    }

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

        Node root = construct(arr);
        traversal(root, root, data);

        ArrayList<Integer> list = new ArrayList<>();
        traversalAlternate(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) < data) {
                i++;
            } else if (list.get(i) + list.get(j) > data) {
                j--;
            } else {
                System.out.println(list.get(i) + " " + list.get(j));
                i++;
                j--;
            }
        }
        // write your code here
    }
}
