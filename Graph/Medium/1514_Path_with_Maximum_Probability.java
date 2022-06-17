
/**
 * You are given an undirected weighted graph of n nodes (0-indexed),
 * represented by an edge list where edges[i] = [a, b] is an undirected edge
 * connecting the nodes a and b with a probability of success of traversing that
 * edge succProb[i].
 * 
 * Given two nodes start and end, find the path with the maximum probability of
 * success to go from start to end and return its success probability.
 * 
 * If there is no path from start to end, return 0. Your answer will be accepted
 * if it differs from the correct answer by at most 1e-5.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start =
 * 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability
 * of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 * Example 2:
 * 
 * 
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start =
 * 0, end = 2
 * Output: 0.30000
 * Example 3:
 * 
 * 
 * 
 * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * Output: 0.00000
 * Explanation: There is no path between 0 and 2.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 10^4
 * 0 <= start, end < n
 * start != end
 * 0 <= a, b < n
 * a != b
 * 0 <= succProb.length == edges.length <= 2*10^4
 * 0 <= succProb[i] <= 1
 * There is at most one edge between every two nodes.
 * Accepted
 * 46,341
 * Submissions
 * 98,371
 */
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int src;
        double prob;

        Pair(int src, double prob) {
            this.src = src;
            this.prob = prob;
        }

        public int compareTo(Pair o) {
            return ((Double) o.prob).compareTo((Double) this.prob);
        }
    }

    class Edge {
        int src, nbr;
        double prob;

        Edge(int src, int nbr, double prob) {
            this.src = src;
            this.nbr = nbr;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < edges.length; i++) {
            int edge[] = edges[i];
            graph.get(edge[0]).add(new Edge(edge[0], edge[1], succProb[i]));
            graph.get(edge[1]).add(new Edge(edge[1], edge[0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1.0));
        double[] probCache = new double[n];
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (pair.src == end)
                return pair.prob;
            probCache[pair.src] = pair.prob;
            for (Edge e : graph.get(pair.src)) {
                if (probCache[e.nbr] >= (pair.prob * e.prob))
                    continue;
                pq.add(new Pair(e.nbr, pair.prob * e.prob));
            }
        }
        return 0.00000;
    }
}