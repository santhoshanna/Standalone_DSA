package com.santhosh.datastructures.HeapsAndHashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair> {
        private int data;
        private int listIndex;
        private int dataIndex;

        public Pair(int listIndex, int dataIndex, int data) {
            this.data = data;
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
        }

        @Override
        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        while (pq.size() > 0) {
            Pair pair = pq.remove();
            rv.add(pair.data);
            int currentListIndex = pair.listIndex;
            int currentDataIndex = pair.dataIndex;

            if (currentDataIndex + 1 < lists.get(currentListIndex).size()) {
                pair.data = lists.get(currentListIndex).get(++currentDataIndex);
                pair.dataIndex = currentDataIndex;
                pq.add(pair);
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
