
/**
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1
 * and n - 1 edges.
 * 
 * You are given the integer n and the array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi in the tree.
 * 
 * Return an array answer of length n where answer[i] is the sum of the
 * distances between the ith node in the tree and all other nodes.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation: The tree is shown above.
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.
 * Hence, answer[0] = 8, and so on.
 * Example 2:
 * 
 * 
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 3:
 * 
 * 
 * Input: n = 2, edges = [[1,0]]
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 3 * 104
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * The given input represents a valid tree.
 * Accepted
 * 41,525
 * Submissions
 * 78,233
 */

import java.util.*;

class Solution {
    class Pair {
        int sum, children;

        Pair(int sum, int children) {
            this.sum = sum;
            this.children = children;
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<Integer>());
        for (int edge[] : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        int ans[] = new int[n];
        HashMap<Integer, Pair> hm = new HashMap<>();
        getChildSum(tree, 0, ans, hm, 0);
        for (int child : tree.get(0)) {
            solver(tree, child, hm, ans, 0);
        }
        return ans;
    }

    public Pair getChildSum(ArrayList<ArrayList<Integer>> tree, int src, int ans[], HashMap<Integer, Pair> hm,
            int parent) {
        if (tree.get(src).size() == 0) {
            Pair p = new Pair(0, 0);
            hm.put(src, p);
            return p;
        }
        int children = 0, sum = 0;
        for (int child : tree.get(src)) {
            if (child == parent)
                continue;
            Pair pair = getChildSum(tree, child, ans, hm, src);
            sum += 1;
            children++;
            children += pair.children;
            sum += pair.sum + pair.children;
        }
        ans[src] = sum;
        Pair p = new Pair(sum, children);
        hm.put(src, p);
        return p;
    }

    public void solver(ArrayList<ArrayList<Integer>> tree, int src, HashMap<Integer, Pair> hm, int ans[], int parent) {
        ans[src] = ans[parent] - (2 * hm.get(src).children) + tree.size() - 2;
        for (int child : tree.get(src)) {
            if (child == parent)
                continue;
            solver(tree, child, hm, ans, src);
        }
    }

}