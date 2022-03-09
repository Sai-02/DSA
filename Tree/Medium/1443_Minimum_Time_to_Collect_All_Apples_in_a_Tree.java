
/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1,
 * which has some apples in their vertices. You spend 1 second to walk over one
 * edge of the tree. Return the minimum time in seconds you have to spend to
 * collect all apples in the tree, starting at vertex 0 and coming back to this
 * vertex.
 * 
 * The edges of the undirected tree are given in the array edges, where edges[i]
 * = [ai, bi] means that exists an edge connecting the vertices ai and bi.
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true
 * means that vertex i has an apple; otherwise, it does not have any apple.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.
 * Example 2:
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.
 * Example 3:
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,false,false,false,false,false]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * fromi < toi
 * hasApple.length == n
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int edge[] = new int[1];
        solver(adj, 0, hasApple, edge, new HashSet<Integer>());
        return edge[0] * 2;
    }

    public boolean solver(ArrayList<ArrayList<Integer>> adj, int parent, List<Boolean> hasApple, int edge[],
            HashSet<Integer> h) {
        if (h.contains(parent))
            return false;
        h.add(parent);
        boolean found = false;
        if (adj.get(parent).size() == 0)
            return hasApple.get(parent);
        for (int child : adj.get(parent)) {
            boolean ans = solver(adj, child, hasApple, edge, h);
            if (ans) {
                edge[0]++;
            }
            found = found || ans;
        }
        if (!found && hasApple.get(parent)) {
            found = true;
        }
        h.remove(parent);
        return found;
    }
}