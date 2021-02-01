package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFT {
    public static class Edge {
        private int src;
        private int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        private int vertex;
        private String psf;

        Pair(int vertex, String psf) {
            this.vertex = vertex;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));
        while (queue.size() > 0) {
            Pair first = queue.remove();
            if (!visited[first.vertex]) {
                visited[first.vertex] = true;
                System.out.println(first.vertex + "@" + first.psf);
                for (Edge edge : graph[first.vertex]) {
                    if (visited[edge.nbr] == false) {
                        queue.add(new Pair(edge.nbr, first.psf + "" + edge.nbr));
                    }
                }
            }
        }
    }
}
