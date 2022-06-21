
/**
 * You are given a graph with N nodes and M directed edges. Find the number of
 * Strongly connected components in the graph.
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
 * Print in one line the number of strongly connected components in the graph.
 * 
 * Example
 * Sample Input
 * 
 * 5 6
 * 1 4
 * 1 3
 * 2 4
 * 3 4
 * 4 5
 * 5 1
 * 
 * Sample Output
 * 2
 */

import java.util.*;
import java.io.*;
import java.util.*;

public class Kosaraju_Algorithm {
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

        System.out.println(kosaraju(graph, n));
    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> list, int n) {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(list, st, i, visited);
            }
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            for (int node : list.get(i)) {
                graph.get(node).add(i);
            }
        }
        int count = 0;
        Arrays.fill(visited, false);
        while (!st.empty()) {
            int i = st.pop();
            if (!visited[i]) {
                dfs2(graph, i, visited);
                count++;
            }
        }
        return count;

    }

    public static void dfs2(ArrayList<ArrayList<Integer>> graph, int src, boolean visited[]) {
        visited[src] = true;
        for (int nbr : graph.get(src)) {
            if (!visited[nbr])
                dfs2(graph, nbr, visited);
        }
    }

    public static void dfs1(ArrayList<ArrayList<Integer>> list, Stack<Integer> st, int src, boolean visited[]) {
        visited[src] = true;
        for (int nbr : list.get(src)) {
            if (!visited[nbr])
                dfs1(list, st, nbr, visited);
        }
        st.push(src);
    }
}