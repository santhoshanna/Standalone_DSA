package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MultiSolver {
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

    public static class Pair implements Comparable<Pair> {
        private String psf;
        private int wsf;

        public Pair(String path, int wt) {
            this.psf = path;
            this.wsf = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    private static PriorityQueue<Pair> pq = new PriorityQueue<>();
    private static int originalSrc;
    private static String spath;
    private static int spathwt = Integer.MAX_VALUE;
    private static String lpath;
    private static int lpathwt = Integer.MIN_VALUE;
    private static String cpath;
    private static int cpathwt = Integer.MAX_VALUE;
    private static String fpath;
    private static int fpathwt = Integer.MIN_VALUE;

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if (src == dest) {
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if (wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }
            if (wsf > criteria) {
                int computedCeil = Math.min(wsf, cpathwt);
                if (cpathwt > computedCeil) {
                    cpathwt = computedCeil;
                    cpath = psf;
                }
            }
            if (wsf < criteria) {
                int computedCeil = Math.max(wsf, fpathwt);
                if (fpathwt < computedCeil) {
                    fpathwt = computedCeil;
                    fpath = psf;
                }
            }
            if (pq.size() < k) {
                pq.add(new Pair(psf, wsf));
            } else {
                if (pq.peek().wsf < wsf) {
                    pq.remove();
                    pq.add(new Pair(psf, wsf));
                }
            }
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
            }
        }
        visited[src] = false;
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
        int dest = Integer.parseInt(br.readLine());

        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }
}
