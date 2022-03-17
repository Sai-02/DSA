
/**
 * 1. You are given a graph.
 * 2. You are required to find and print if the graph is cyclic.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * true if the graph is cyclic, false otherwise
 * 
 * Example
 * Sample Input
 * 
 * 7
 * 6
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
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

public class Is_Graph_Cyclic {
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
        boolean visited[] = new boolean[vtces];
        boolean ans[] = new boolean[1];
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited, ans);
            }
        }
        System.out.println(ans[0]);
    }

    public static void bfs(ArrayList<Edge> graph[], int src, boolean visited[], boolean ans[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.remove();
            if (visited[node]) {
                ans[0] = true;
                return;
            }
            visited[node] = true;
            for (Edge e : graph[node]) {
                if (!visited[e.nbr]) {
                    q.add(e.nbr);
                }
            }
        }
    }
}