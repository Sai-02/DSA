
/**
 * 1. You are given a graph, a src vertex and a destination vertex.
 * 2. You are give a number named "criteria" and a number "k".
 * 3. You are required to find and print the values of
 * 3.1 Smallest path and it's weight separated by an "@"
 * 3.2 Largest path and it's weight separated by an "@"
 * 3.3 Just Larger path (than criteria in terms of weight) and it's weight
 * separated by an "@"
 * 3.4 Just smaller path (than criteria in terms of weight) and it's weight
 * separated by an "@"
 * 3.5 Kth largest path and it's weight separated by an "@"
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * Check sample output
 * 
 * Example
 * Sample Input
 * 
 * 7
 * 9
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 40
 * 3 4 2
 * 4 5 3
 * 5 6 3
 * 4 6 8
 * 2 5 5
 * 0
 * 6
 * 30
 * 4
 * 
 * Sample Output
 * Smallest Path = 01256@28
 * Largest Path = 032546@66
 * Just Larger Path than 30 = 012546@36
 * Just Smaller Path than 30 = 01256@28
 * 4th largest path = 03456@48
 * 
 * Question Video
 * 
 * Play Video
 * 
 */

import java.io.*;
import java.util.*;

public class Multisolver_Smallest_Longest_Ceil_Floor_Kthlargest_Path {
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

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
            String psf, int wsf) {
        if (visited[src])
            return;
        if (src == dest) {
            if (wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if (criteria < wsf && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }
            if (criteria > wsf && fpathwt < wsf) {
                fpathwt = wsf;
                fpath = psf;
            }
            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                pq.add(new Pair(wsf, psf));
                pq.remove();
            }
            return;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
        }
        visited[src] = false;
    }
}