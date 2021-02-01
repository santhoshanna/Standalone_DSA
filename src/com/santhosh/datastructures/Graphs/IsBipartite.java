package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsBipartite {
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

    public static class Pair {
        private int vertex;
        private String psf;
        private int level;

        Pair(int vertex, String psf, int level) {
            this.vertex = vertex;
            this.psf = psf;
            this.level = level;
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
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == -1) {
                boolean isBipartite = isBipartite(graph, i, visited);
                if (isBipartite == false) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
        for (int i = 0; i < visited.length; i++) {
            System.out.println("Node" + i + " : belongs to set" + visited[i]);
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while (queue.size() > 0) {
            Pair front = queue.remove();
            if (visited[front.vertex] == -1) {
                visited[front.vertex] = front.level;
            } else {
                if (visited[front.vertex] != front.level) {
                    return false;
                }
            }

            for (Edge edge : graph[src]) {
                if (visited[edge.nbr] == -1) {
                    queue.add(new Pair(edge.nbr, front.psf + edge.nbr, front.level + 1));
                }
            }
        }
        return true;
    }
}
