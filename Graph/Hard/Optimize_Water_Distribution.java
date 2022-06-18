
/**
 * There are n construction sites in a town. We want to supply water for all the
 * construction sites by building wells and laying pipes.
 * 
 * For each site i, we can either build a well inside it directly with cost
 * wells[i-1], or pipe in water from another well to it. The costs to lay pipes
 * between
 * sites are given by the 2d array cost, where each row of cost contains 3
 * numbers ai,bi and wi where wi is the cost to connect ai to bi. connections
 * are bidirectional.
 * 
 * Return the minimum total cost to supply water to all the construction sites.
 * 
 * Constraints
 * 1 <= n <= 10^4
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= cost.length <= 10^4
 * cost[i].length == 3
 * 
 * Format
 * Input
 * First line contains two integers V and E denoting number of houses and number
 * of pipelines respectively.
 * Second line contains n integer denoting cost to dig well at ith house.
 * Each of next E lines contain 3 numbers ui and vi and c denoting a pipeline
 * between u and v with cost c to build.
 * 
 * Output
 * Return the minimum total cost to supply water to all the construction sites.
 * 
 * Example
 * Sample Input
 * 
 * 3 2
 * 1 2 2
 * 1 2 1
 * 2 3 1
 * 
 * 
 * Sample Output
 * 3
 */

import java.io.*;
import java.util.*;

public class Optimize_Water_Distribution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);

        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int ans = 0;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Pair>());
        for (int pipe[] : pipes) {
            graph.get(pipe[0]).add(new Pair(pipe[1], pipe[2]));
            graph.get(pipe[1]).add(new Pair(pipe[0], pipe[2]));
        }
        for (int i = 1; i <= n; i++) {
            graph.get(0).add(new Pair(i, wells[i - 1]));
            graph.get(i).add(new Pair(0, wells[i - 1]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean visited[] = new boolean[n + 1];
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (visited[pair.nbr])
                continue;
            visited[pair.nbr] = true;
            ans += pair.wt;
            for (Pair e : graph.get(pair.nbr)) {
                if (visited[e.nbr])
                    continue;
                pq.add(new Pair(e.nbr, e.wt));
            }
        }
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int nbr, wt;

        Pair(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}