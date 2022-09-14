
/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
 * all possible paths from node 0 to node n - 1 and return them in any order.
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * 
 * 
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 
 * 
 * Constraints:
 * 
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 * Accepted
 * 332,676
 * Submissions
 * 408,874
 */

import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] arr) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            graph.add(new ArrayList<Integer>());
            for (int j = 0; j < arr[i].length; j++) {
                graph.get(i).add(arr[i][j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, arr.length - 1, new ArrayList<Integer>(), ans, graph);
        return ans;
    }

    public void dfs(int src, int tar, ArrayList<Integer> temp, List<List<Integer>> ans,
            ArrayList<ArrayList<Integer>> graph) {
        if (src == tar) {
            List<Integer> list = new ArrayList<>(temp);
            list.add(src);
            ans.add(list);
            return;
        }
        temp.add(src);
        for (int nbr : graph.get(src)) {
            dfs(nbr, tar, temp, ans, graph);
        }
        temp.remove(temp.size() - 1);
    }
}