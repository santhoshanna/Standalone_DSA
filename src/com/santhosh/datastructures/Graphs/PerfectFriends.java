package com.santhosh.datastructures.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriends {

    public static class Club {
        private int original;
        private int partner;

        Club(int original, int partner) {
            this.original = original;
            this.partner = partner;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int noOfPeople = Integer.parseInt(br.readLine());
        int noOfClubs = Integer.parseInt(br.readLine());

        ArrayList<Club>[] graph = new ArrayList[noOfPeople];
        for (int i = 0; i < noOfPeople; i++) {
            graph[i] = new ArrayList<>();
        }

        // write your code here
        for (int i = 0; i < noOfClubs; i++) {
            String[] clubPartners = br.readLine().split(" ");
            int original = Integer.parseInt(clubPartners[0]);
            int partner = Integer.parseInt(clubPartners[1]);

            graph[original].add(new Club(original, partner));
            graph[partner].add(new Club(partner, original));
        }

        boolean[] visited = new boolean[noOfPeople];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < noOfPeople; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                components(graph, i, visited, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps.size());
        int cartesianProduct = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                cartesianProduct += count;
            }
        }
        System.out.println(cartesianProduct);
    }

    public static void components(ArrayList<Club>[] graph, int original, boolean[] visited, ArrayList<Integer> comp) {

        visited[original] = true;
        comp.add(original);
        for (Club club : graph[original]) {
            if (visited[club.partner] == false) {
                components(graph, club.partner, visited, comp);
            }
        }
    }
}
