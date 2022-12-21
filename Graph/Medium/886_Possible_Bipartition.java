
/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of
 * any size. Each person may dislike some other people, and they should not go
 * into the same group.
 * 
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi]
 * indicates that the person labeled ai does not like the person labeled bi,
 * return true if it is possible to split everyone into two groups in this way.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 * Example 2:
 * 
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * 
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * All the pairs of dislikes are unique.
 */

import java.util.*;

class Solution {
    boolean ans = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int d[] : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);

        }
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!hm.containsKey(i))
                dfs(graph, i, hm, true);
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, HashMap<Integer, Boolean> hm, Boolean count) {
        if (hm.containsKey(src)) {
            if (count != hm.get(src))
                ans = false;
            return;
        }
        hm.put(src, count);
        for (int child : graph.get(src)) {
            dfs(graph, child, hm, !count);
        }
    }
}