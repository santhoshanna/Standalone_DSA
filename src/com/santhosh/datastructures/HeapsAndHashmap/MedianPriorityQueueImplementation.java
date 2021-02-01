package com.santhosh.datastructures.HeapsAndHashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueueImplementation {
    public static class MedianPriorityQueue {
        private PriorityQueue<Integer> left;
        private PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            this.left = new PriorityQueue<>(Collections.reverseOrder());
            this.right = new PriorityQueue<>();
        }

        public void add(int val) {
            // write your code here
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }
            if (right.size() - left.size() > 1) {
                left.add(right.remove());
            } else if (left.size() - right.size() > 1) {
                right.add(left.remove());
            }
        }

        public int remove() {
            // write your code here
            if (left.size() == 0 && right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            // write your code here
            if (left.size() == 0 && right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            // write your code here
            return left.size() + right.size();
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
