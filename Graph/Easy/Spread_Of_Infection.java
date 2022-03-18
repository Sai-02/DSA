
/**
 * 1. You are given a graph, representing people and their connectivity.
 * 2. You are also given a src person (who got infected) and time t.
 * 3. You are required to find how many people will get infected in time t, if
 * the infection spreads to neighbors of infected person in 1 unit of time.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * count of people infected by time t
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
 * 6
 * 3
 * 
 * Sample Output
 * 4
 * 
 * Question Video
 * 
 * Play Video
 * Related Resources
 */

import java.io.*;
import java.util.*;

public class Spread_Of_Infection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        System.out.println(solver(graph, src, t));
    }

    public static int solver(ArrayList<Edge> graph[], int src, int t) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        boolean visited[] = new boolean[graph.length];
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            visited[pair.src] = true;
            if (pair.level < t)
                count++;
            else
                break;
            for (Edge e : graph[pair.src]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, pair.level + 1));
                }
            }
        }
        return count - 1;
    }

}