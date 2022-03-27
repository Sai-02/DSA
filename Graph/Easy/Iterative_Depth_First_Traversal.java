
/**
 * 1. You are given a graph, and a source vertex.
 * 2. You are required to do a iterative depth first traversal and print which
 * vertex is reached via which
 * path, starting from the source.
 * 
 * Note -> For output, check the sample output and question video. Iterative
 * depth first traversal
 * should mimic "Reverse preorder" i.e. nbr with highest value should be visited
 * first and
 * should be printed on the way down in recursion.
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
 * 8
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 10
 * 3 4 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 2
 * 
 * Sample Output
 * 2@2
 * 3@23
 * 4@234
 * 6@2346
 * 5@23465
 * 0@230
 * 1@2301
 */
import java.io.*;
import java.util.*;

public class Iterative_Depth_First_Traversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));
        boolean visited[] = new boolean[vtces];
        while (!st.empty()) {
            Pair pair = st.pop();
            if (visited[pair.v])
                continue;
            else {
                visited[pair.v] = true;
                System.out.println(pair.v + "@" + pair.psf);
                for (Edge e : graph[pair.v]) {
                    if (!visited[e.nbr]) {
                        st.push(new Pair(e.nbr, pair.psf + e.nbr));
                    }
                }
            }
        }
    }
}