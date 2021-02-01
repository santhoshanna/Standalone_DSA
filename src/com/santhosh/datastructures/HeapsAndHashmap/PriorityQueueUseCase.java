package com.santhosh.datastructures.HeapsAndHashmap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueUseCase {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};

        for (int rank : ranks) {
            pq.add(rank);
        }

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        int[] scores = {100, 99, 98, 66, 88, 77, 35};
        for (int score : scores) {
            pq2.add(score);
        }

        while (pq2.size() > 0) {
            System.out.println(pq2.peek());
            pq2.remove();
        }
    }
}
