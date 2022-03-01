
/**
 * Easy
 * 
 * 1. You are given a graph, a src vertex and a destination vertex.
 * 2. You are required to find if a path exists between src and dest. If it
 * does, print true
 * otherwise print false.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * true if path exists, false otherwise
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
 * true
 * 
 * Question Video
 * 
 * Play Video
 * Related Resources
 */
import java.io.*;
import java.util.*;

public class Has_Path {
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
        System.out.println(hasPath(graph, src, dest, visited));
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest)
            return true;
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr] && hasPath(graph, edge.nbr, dest, visited))
                return true;
        }
        visited[src] = false;
        return false;
    }

}