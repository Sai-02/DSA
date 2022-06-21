
/**
 * Given a Directed Graph, find a Mother Vertex in the Graph (if present).
 * A Mother Vertex is a vertex through which we can reach all the other vertices
 * of the Graph.
 * 
 * Constraints
 * 1<= N <= 10000
 * 1<= M <= (N*(N-1))/2
 * 1<= ai, bi <= N
 * 
 * Format
 * Input
 * First line contains two space separated integers,N and M. Then M lines
 * follow, each line has 2 space separated integers ai and bi.
 * 
 * Output
 * Print the mother vertex if present else print -1.
 * 
 * Example
 * Sample Input
 * 
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 * 
 * Sample Output
 * 1
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class Mother_Vertex {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }

    public static int findMotherVertex(int n, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs1(adj, i, st, visited);
        }
        int vertex = st.peek();
        Arrays.fill(visited, false);
        dfs2(vertex, adj, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return -1;
        }
        return vertex + 1;

    }

    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int src, Stack<Integer> st, boolean visited[]) {
        visited[src] = true;
        for (int child : adj.get(src)) {
            if (!visited[child])
                dfs1(adj, child, st, visited);
        }
        st.push(src);
    }

    public static void dfs2(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
        visited[src] = true;
        for (int child : adj.get(src)) {
            if (!visited[child]) {
                dfs2(child, adj, visited);
            }
        }

    }

}