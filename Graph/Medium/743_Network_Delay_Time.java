
/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given
 * times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it
 * takes for a signal to travel from source to target.
 * 
 * We will send a signal from a given node k. Return the time it takes for all
 * the n nodes to receive the signal. If it is impossible for all the n nodes to
 * receive the signal, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * 
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * 
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 * Accepted
 * 276,778
 * Submissions
 * 552,472
 */
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int src, tsf;

        Pair(int src, int tsf) {
            this.src = src;
            this.tsf = tsf;
        }

        public int compareTo(Pair o) {
            return this.tsf - o.tsf;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<int[]>());
        for (int time[] : times) {
            int a[] = new int[2];
            a[0] = time[1];
            a[1] = time[2];
            graph.get(time[0] - 1).add(a);
        }
        pq.add(new Pair(k, 0));
        boolean visited[] = new boolean[n];
        int ans = 0;
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (visited[pair.src - 1])
                continue;
            visited[pair.src - 1] = true;
            n--;
            ans = pair.tsf;
            for (int[] a : graph.get(pair.src - 1)) {
                pq.add(new Pair(a[0], a[1] + pair.tsf));
            }

        }
        return n == 0 ? ans : -1;

    }
}