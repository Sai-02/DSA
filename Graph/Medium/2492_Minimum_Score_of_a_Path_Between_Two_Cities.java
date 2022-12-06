
/**
 * You are given a positive integer n representing n cities numbered from 1 to
 * n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei]
 * indicates that there is a bidirectional road between cities ai and bi with a
 * distance equal to distancei. The cities graph is not necessarily connected.
 * 
 * The score of a path between two cities is defined as the minimum distance of
 * a road in this path.
 * 
 * Return the minimum possible score of a path between cities 1 and n.
 * 
 * Note:
 * 
 * A path is a sequence of roads between two cities.
 * It is allowed for a path to contain the same road multiple times, and you can
 * visit cities 1 and n multiple times along the path.
 * The test cases are generated such that there is at least one path between 1
 * and n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * Output: 5
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 ->
 * 4. The score of this path is min(9,5) = 5.
 * It can be shown that no other path has less score.
 * Example 2:
 * 
 * 
 * Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * Output: 2
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1
 * -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * There are no repeated edges.
 * There is at least one path between 1 and n.
 * Accepted
 * 9,905
 * Submissions
 * 22,498D
 */
import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int road[] : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        HashSet<Integer> connected = new HashSet<>();
        dfs(graph, 1, connected);
        dfs(graph, n, connected);
        int minPath = Integer.MAX_VALUE;
        for (int road[] : roads) {
            if (connected.contains(road[0]) || connected.contains(road[1])) {
                minPath = Math.min(minPath, road[2]);
            }
        }
        return minPath;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, HashSet<Integer> connected) {
        if (connected.contains(src))
            return;
        connected.add(src);
        for (int nbr : graph.get(src)) {
            if (!connected.contains(nbr))
                dfs(graph, nbr, connected);
        }
    }
}