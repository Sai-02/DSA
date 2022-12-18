
/**
 * There is an undirected graph consisting of n nodes numbered from 1 to n. You
 * are given the integer n and a 2D array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi. The graph can be
 * disconnected.
 * 
 * You can add at most two additional edges (possibly none) to this graph so
 * that there are no repeated edges and no self-loops.
 * 
 * Return true if it is possible to make the degree of each node in the graph
 * even, otherwise return false.
 * 
 * The degree of a node is the number of edges connected to it.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, edges = [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]
 * Output: true
 * Explanation: The above diagram shows a valid way of adding an edge.
 * Every node in the resulting graph is connected to an even number of edges.
 * Example 2:
 * 
 * 
 * Input: n = 4, edges = [[1,2],[3,4]]
 * Output: true
 * Explanation: The above diagram shows a valid way of adding two edges.
 * Example 3:
 * 
 * 
 * Input: n = 4, edges = [[1,2],[1,3],[1,4]]
 * Output: false
 * Explanation: It is not possible to obtain a valid graph with adding at most 2
 * edges.
 * 
 * 
 * Constraints:
 * 
 * 3 <= n <= 105
 * 2 <= edges.length <= 105
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * ai != bi
 * There are no repeated edges.
 * Accepted
 * 4,260
 * Submissions
 * 15,840
 */
import java.util.*;

class Solution {
    int count = 0;
    List<Integer> a = new ArrayList<>();

    public boolean isPossible(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (List<Integer> e : edges) {
            graph.get(e.get(0)).add(e.get(1));
            graph.get(e.get(1)).add(e.get(0));
        }
        HashSet<Integer> h = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (!h.contains(i)) {
                dfs(graph, i, h);
            }
        }
        if (count == 0)
            return true;
        if (count == 2) {
            int src1 = a.get(0);
            int src2 = a.get(1);
            if (!isConnected(graph, src1, src2))
                return true;
            HashSet<Integer> nbrs = new HashSet<>();
            for (int nbr : graph.get(src1))
                nbrs.add(nbr);
            for (int nbr : graph.get(src2))
                nbrs.add(nbr);
            if (n > nbrs.size())
                return true;
        }
        if (count == 4) {
            int src1 = a.get(0);
            int src2 = a.get(1);
            int src3 = a.get(2);
            int src4 = a.get(3);
            if ((!isConnected(graph, src1, src2) && !isConnected(graph, src3, src4))
                    || (!isConnected(graph, src1, src3) && !isConnected(graph, src2, src4))
                    || (!isConnected(graph, src1, src4) && !isConnected(graph, src3, src2)))
                return true;
        }
        return false;

    }

    public boolean isConnected(ArrayList<ArrayList<Integer>> graph, int src1, int src2) {
        for (int child : graph.get(src1)) {
            if (child == src2)
                return true;
        }
        return false;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, HashSet<Integer> h) {
        if (h.contains(src))
            return;
        h.add(src);
        if (graph.get(src).size() % 2 != 0) {
            count++;
            a.add(src);
        }
        for (int child : graph.get(src)) {
            dfs(graph, child, h);
        }
    }
}
