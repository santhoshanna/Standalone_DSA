package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintAllPaths {
    public static class Edge {
        private int src;
        private int nbr;
        private int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void paths(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited) {
        if (src == dest) {
            System.out.println(path);
            return;
        }
        if (visited[src] == true) {
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            paths(graph, edge.nbr, dest, path + edge.nbr + "", visited);
        }
        visited[src] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] edgePath = br.readLine().split(" ");
            int v1 = Integer.parseInt(edgePath[0]);
            int v2 = Integer.parseInt(edgePath[1]);
            int wt = Integer.parseInt(edgePath[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertices];
        paths(graph, src, dest, src + "", visited);
    }
}
