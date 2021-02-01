package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPathInWeights {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        String psf;
        int weight;

        Pair(int vertex, String psf, int weight) {
            this.psf = psf;
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
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

        int src = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, src + "", 0));
        while (queue.size() > 0) {
            Pair front = queue.remove();
            if (visited[front.vertex] == false) {
                System.out.println(front.vertex + " via " + front.psf + " @ " + front.weight);
                visited[front.vertex] = true;
                for (Edge edge : graph[front.vertex]) {
                    if (visited[edge.nbr] == false) {
                        queue.add(new Pair(edge.nbr, front.psf + "" + edge.nbr, front.weight + edge.wt));
                    }
                }
            }
        }

    }
}
