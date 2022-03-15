
/**
 * 1. You are given a graph and a src vertex.
 * 2. You are required to find and print all hamiltonian paths and cycles
 * starting from src. The cycles must end with "*" and paths with a "."
 * 
 * Note -> A hamiltonian path is such which visits all vertices without visiting
 * any twice. A hamiltonian path becomes a cycle if there is an edge between
 * first and last vertex.
 * Note -> Print in lexicographically increasing order.
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
 * 0 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 2 5 10
 * 0
 * 
 * Sample Output
 * 0123456.
 * 0123465.
 * 0125643*
 * 0346521*
 */
import java.io.*;
import java.util.*;

public class Hamiltonian_Path_And_Cycle {
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
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        boolean visited[] = new boolean[vtces];
        int count[] = new int[1];
        solver(graph, src, src, ans, sb, count, visited);
        for (String str : ans) {
            System.out.println(str);
        }
    }

    public static void solver(ArrayList<Edge> graph[], int src, int osrc, ArrayList<String> ans, StringBuilder sb,
            int count[], boolean visited[]) {
        if (visited[src])
            return;
        visited[src] = true;
        sb.append(src + "");
        count[0]++;
        boolean corner = false, nbr = false;
        if (count[0] == visited.length)
            corner = true;
        for (Edge edge : graph[src]) {
            if (edge.nbr == osrc)
                nbr = true;
            solver(graph, edge.nbr, osrc, ans, sb, count, visited);
        }
        if (corner) {
            if (nbr) {
                sb.append("*");
                ans.add(sb.toString());
            } else {
                sb.append(".");
                ans.add(sb.toString());
            }
            sb.setLength(sb.length() - 1);
        }
        visited[src] = false;
        count[0]--;
        sb.setLength(sb.length() - 1);
    }
}
