
/**
 * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1
 * edges.
 * 
 * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai,
 * bi] indicates that there is an edge between nodes ai and bi in the tree. You
 * are also given an integer array restricted which represents restricted nodes.
 * 
 * Return the maximum number of nodes you can reach from node 0 without visiting
 * a restricted node.
 * 
 * Note that node 0 will not be a restricted node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted =
 * [4,5]
 * Output: 4
 * Explanation: The diagram above shows the tree.
 * We have that [0,1,2,3] are the only nodes that can be reached from node 0
 * without visiting a restricted node.
 * Example 2:
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted =
 * [4,2,1]
 * Output: 3
 * Explanation: The diagram above shows the tree.
 * We have that [0,5,6] are the only nodes that can be reached from node 0
 * without visiting a restricted node.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * All the values of restricted are unique.
 */

import java.util.*;

class Solution {
    int count = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        HashSet<Integer> h = new HashSet<>();
        for (int val : restricted)
            h.add(val);
        for (int edge[] : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(tree, 0, -1, h);
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> tree, int root, int parent, HashSet<Integer> h) {
        if (h.contains(root))
            return;
        count++;
        for (int child : tree.get(root)) {
            if (child == parent)
                continue;
            dfs(tree, child, root, h);
        }
    }
}