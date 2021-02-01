package com.santhosh.datastructures.StacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DynamicQueueImplementation {

    public static class CustomQueue {
        private int[] d;
        private int front;
        private int size;

        CustomQueue(int n) {
            this.d = new int[n];
            this.front = 0;
            this.size = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            // write ur code here
            for (int i = 0; i < size; i++) {
                System.out.print(d[(front + i) % d.length] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            // write ur code here
            if (size == d.length) {
                //System.out.println("Queue overflow");
                int[] temp = new int[2 * d.length];
                for (int i = 0; i < size; i++) {
                    temp[i] = d[(i + front) % d.length];
                }
                d = temp;
                front = 0;
                int rear = (front + size) % d.length;
                d[rear] = val;
                size++;
            } else {
                int rear = (front + size) % d.length;
                d[rear] = val;
                size++;
            }
        }

        int remove() {
            // write ur code here
            if (size != 0) {
                int val = d[(front % d.length)];
                size--;
                front = (front + 1) % d.length;
                return val;
            } else {
                System.out.println("Queue underflow");
                return -1;
            }
        }

        int peek() {
            // write ur code here
            if (size != 0) {
                return d[front];
            } else {
                System.out.println("Queue underflow");
                return -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

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
            } else if (str.startsWith("display")) {
                qu.display();
            }
            str = br.readLine();
        }
    }
}
