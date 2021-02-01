package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HasAPath {
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

    public static boolean haspath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                boolean nextNeighborToDestPath = haspath(graph, edge.nbr, dest, visited);
                if (nextNeighborToDestPath) {
                    return true;
                }
            }
        }
        visited[src] = false;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] edgeData = br.readLine().split(" ");
            int v1 = Integer.parseInt(edgeData[0]);
            int v2 = Integer.parseInt(edgeData[1]);
            int wt = Integer.parseInt(edgeData[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertices];
        System.out.println(haspath(graph, src, dest, visited));
        // write your code here
    }
}
