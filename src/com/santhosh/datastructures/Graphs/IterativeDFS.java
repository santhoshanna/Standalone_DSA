package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vertex;
        String psf;

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

        // write your code here
        Stack<Pair> stack = new Stack<>();
        boolean[] visited = new boolean[vtces];

        stack.add(new Pair(src, src + ""));
        while (stack.size() != 0) {
            Pair tos = stack.pop();
            if (visited[tos.vertex] == true) {
                continue;
            }
            visited[tos.vertex] = true;
            System.out.println(tos.vertex + "@" + tos.psf);

            for (Edge edge : graph[tos.vertex]) {
                if (visited[edge.nbr] == false) {
                    stack.push(new Pair(edge.nbr, tos.psf + edge.nbr));
                }
            }
        }
    }
}
