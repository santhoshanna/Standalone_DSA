package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IsGraphConnected {
    public static class Edge {
        private int src;
        private int nbr;
        private int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<Edge>();
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
        boolean[] visited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                connectedComponents(graph, i, visited, comp);
                components.add(comp);
            }
        }
        if (components.size() == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void connectedComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                connectedComponents(graph, edge.nbr, visited, comp);
            }
        }
    }
}
