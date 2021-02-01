package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsGraphCyclic {
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

        Pair(int src, String psf) {
            this.psf = psf;
            this.vertex = src;
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


        boolean[] visited = new boolean[vtces];
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == false) {
                boolean cycle = isCyclic(graph, i, visited);
                if (cycle) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0) {
            Pair front = queue.remove();
            if (visited[front.vertex] == true) {
                return true;
            }
            visited[front.vertex] = true;
            for (Edge edge : graph[front.vertex]) {
                if (visited[edge.nbr] == false) {
                    queue.add(new Pair(edge.nbr, front.psf + "" + edge.nbr));
                    //System.out.println(src + "--->" + front.psf);
                }
            }
        }
        return false;
    }
}
