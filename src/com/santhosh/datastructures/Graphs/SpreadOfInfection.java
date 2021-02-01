package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class SpreadOfInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        private int vertex;
        private int time;

        Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here
        int[] visited = new int[vtces];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int count = 0;

        while (queue.size() > 0) {
            Pair front = queue.remove();
            if (visited[front.vertex] > 0) {
                continue;
            }
            visited[front.vertex] = front.time;
            if (front.time > t) {
                break;
            }
            count++;
            for (Edge edge : graph[front.vertex]) {
                if (visited[edge.nbr] == 0) {
                    queue.add(new Pair(edge.nbr, front.time + 1));
                }
            }
        }
        System.out.println(count);
    }
}
