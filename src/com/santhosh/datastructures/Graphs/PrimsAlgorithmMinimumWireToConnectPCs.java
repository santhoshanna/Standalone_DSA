package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithmMinimumWireToConnectPCs {
    public static class Edge {
        private int src;
        private int nbr;
        private int wt;

        Edge(int src, int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
            this.src = src;
        }
    }

    public static class Pair implements Comparable<Pair> {
        private int vertex;
        private int acquiredVertex;
        private int wt;

        Pair(int vertex, int acquiredVertex, int wt) {
            this.acquiredVertex = acquiredVertex;
            this.vertex = vertex;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, -1, 0));

        while (queue.size() > 0) {
            Pair front = queue.remove();
            if (visited[front.vertex] == false) {
                visited[front.vertex] = true;
                if (front.acquiredVertex != -1) {
                    System.out.println("[" + front.vertex + "-" + front.acquiredVertex + "@" + front.wt + "]");
                }
                for (Edge edge : graph[front.vertex]) {
                    if (visited[edge.nbr] == false) {
                        queue.add(new Pair(edge.nbr, front.vertex, edge.wt));
                    }
                }
            }
        }
    }
}
