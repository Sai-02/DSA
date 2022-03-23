
/**
 * 1. You are given a directed acyclic graph. The vertices represent tasks and
 * edges represent
 * dependencies between tasks.
 * 2. You are required to find and print the order in which tasks could be done.
 * The task that should be
 * done at last should be printed first and the task which should be done first
 * should be printed last.
 * This is called topological sort. Check out the question video for details.
 * 
 * Topological sort -> A permutation of vertices for a directed acyclic graph is
 * called topological sort if
 * for all directed edges uv, u appears before v in the graph
 * 
 * Note -> For output, check the sample output and question video.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * Check the sample output
 * 
 * Example
 * Sample Input
 * 
 * 7
 * 7
 * 0 1
 * 1 2
 * 2 3
 * 0 3
 * 4 5
 * 5 6
 * 4 6
 * 
 * Sample Output
 * 4
 * 5
 * 6
 * 0
 * 1
 * 2
 * 3
 */

import java.io.*;
import java.util.*;

public class Order_Of_Compilation {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
        }
        boolean visited[] = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                getTopologicalSort(graph, i, visited, st);
            }
        }
        while (!st.empty()) {
            System.out.println(st.pop());
        }

    }

    public static void getTopologicalSort(ArrayList<Edge> graph[], int src, boolean visited[], Stack<Integer> st) {
        if (visited[src])
            return;
        visited[src] = true;
        for (Edge e : graph[src]) {
            getTopologicalSort(graph, e.nbr, visited, st);
        }
        st.push(src);
    }

}