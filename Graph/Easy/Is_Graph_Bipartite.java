
/**
 * 1. You are given a graph.
 * 2. You are required to find and print if the graph is bipartite
 * 
 * Note -> A graph is called bipartite if it is possible to split it's vertices
 * in two sets of mutually
 * exclusive and exhaustive vertices such that all edges are across sets.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * true if the graph is bipartite, false otherwise
 * 
 * Example
 * Sample Input
 * 
 * 7
 * 8
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 
 * Sample Output
 * false
 * 
 * Question Video
 * 
 * Play Video
 * Related Resources
 */

import java.io.*;
import java.util.*;

public class Is_Graph_Bipartite {
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

    static class Pair {
        int src, level;

        Pair(int src, int level) {
            this.src = src;
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

        int visited[] = new int[vtces];
        Arrays.fill(visited, -1);
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == -1) {
                if (!checkBipartite(graph, i, visited)) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }

    public static boolean checkBipartite(ArrayList<Edge> graph[], int src, int visited[]) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        while (!q.isEmpty()) {
            Pair pair = q.removeFirst();
            if (visited[pair.src] == -1) {
                visited[pair.src] = pair.level;
            } else {
                if (visited[pair.src] != pair.level)
                    return false;
            }
            for (Edge e : graph[pair.src]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, pair.level + 1));
                }
            }
        }
        return true;
    }
}