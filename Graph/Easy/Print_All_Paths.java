
/**
 * 1. You are given a graph, a source vertex and a destination vertex. 2. You
 * are required to find and print all paths between source and destination.
 * Print them in lexicographical order. E.g. Check the following paths 012546
 * 01256 032546 03256 The lexicographically smaller path is printed first.
 * 
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
 * 8
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 0
 * 6
 * 
 * Sample Output
 * 0123456
 * 012346
 * 03456
 * 0346
 * 
 * Question Video
 * 
 * Play Video
 * 
 */

import java.io.*;
import java.util.*;

public class Print_All_Paths {
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

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[vtces];
        ArrayList<String> ans = getAllPaths(graph, src, dest, visited);
        for (String s : ans)
            System.out.println(s);
    }

    public static ArrayList<String> getAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        ArrayList<String> ans = new ArrayList<>();
        if (visited[src])
            return ans;
        if (src == dest) {
            ans.add(dest + "");
            return ans;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            ArrayList<String> temp = getAllPaths(graph, edge.nbr, dest, visited);
            for (String s : temp)
                ans.add(src + s);
        }
        visited[src] = false;
        return ans;
    }

}