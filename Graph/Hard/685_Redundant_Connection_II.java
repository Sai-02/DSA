
/**
 * In this problem, a rooted tree is a directed graph such that, there is
 * exactly one node (the root) for which all other nodes are descendants of this
 * node, plus every node has exactly one parent, except for the root node which
 * has no parents.
 * 
 * The given input is a directed graph that started as a rooted tree with n
 * nodes (with distinct values from 1 to n), with one additional directed edge
 * added. The added edge has two different vertices chosen from 1 to n, and was
 * not an edge that already existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is
 * a pair [ui, vi] that represents a directed edge connecting nodes ui and vi,
 * where ui is a parent of child vi.
 * 
 * Return an edge that can be removed so that the resulting graph is a rooted
 * tree of n nodes. If there are multiple answers, return the answer that occurs
 * last in the given 2D-array.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 * 
 * 
 * Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * Output: [4,1]
 * 
 * 
 * Constraints:
 * 
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * Accepted
 * 56,659
 * Submissions
 * 166,485
 */
import java.util.*;

class Solution {
    int parent[];

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[1001];
        int indegree[] = new int[1001];
        int ans1 = -1, ans2 = -1;
        Arrays.fill(indegree, -1);
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int e[] = edges[i];
            if (indegree[e[1]] == -1) {
                indegree[e[1]] = i;
            } else {
                ans1 = indegree[e[1]];
                ans2 = i;
                break;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == ans2)
                continue;
            int e[] = edges[i];
            if (find(e[1]) == find(e[0])) {
                if (ans1 == -1) {
                    return e;
                } else {
                    return edges[ans1];
                }
            } else
                union(e[0], e[1]);
        }
        return edges[ans2];
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int u, int v) {
        u = find(u);
        v = find(v);
        parent[v] = u;
    }
}