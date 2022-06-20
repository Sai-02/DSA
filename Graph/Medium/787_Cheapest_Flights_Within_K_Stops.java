
/**
 * There are n cities connected by some number of flights. You are given an
 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
 * a flight from city fromi to city toi with cost pricei.
 * 
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
 * src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and
 * has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because
 * it uses 2 stops.
 * Example 2:
 * 
 * 
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
 * = 1
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and
 * has cost 100 + 100 = 200.
 * Example 3:
 * 
 * 
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
 * = 0
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost
 * 500.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 */

import java.util.*;

//  Using Dijkstra Algo

class Solution {
    class Pair implements Comparable<Pair> {
        int src, wt, steps;

        Pair(int src, int wt, int steps) {
            this.wt = wt;
            this.src = src;
            this.steps = steps;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    class Edge {
        int nbr, wt;

        Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int minSteps[] = new int[n];
        int minCosts[] = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Edge>());
        for (int e[] : flights) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, 0));
        minSteps[src] = 0;
        minCosts[src] = 0;
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (pair.src == dst)
                return pair.wt;
            if (pair.steps == k + 1) {
                continue;
            }
            for (Edge e : graph.get(pair.src)) {
                if (minCosts[pair.src] >= pair.wt) {
                    minCosts[pair.src] = pair.wt;
                    pq.add(new Pair(e.nbr, pair.wt + e.wt, pair.steps + 1));
                } else if (minSteps[pair.src] >= pair.steps) {
                    minSteps[pair.src] = pair.steps;
                    pq.add(new Pair(e.nbr, pair.wt + e.wt, pair.steps + 1));
                }

            }
        }
        return -1;
    }
}

// Using Bellman Ford

class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] f : flights) {
                int curr = f[0], next = f[1], price = f[2];
                if (cost[curr] == Integer.MAX_VALUE)
                    continue;
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}