
/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2
 * in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3.
 * Example 2:
 * 
 * 
 * 
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1
 * in consecutive cells, which is better than route [1,3,5,3,5].
 * Example 3:
 * 
 * 
 * Input: heights =
 * [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 * 
 * 
 * Constraints:
 * 
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * Accepted
 * 111,611
 * Submissions
 * 202,461
 */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int i, j, wt;

        Pair(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = heights.length, m = heights[0].length;
        boolean visited[][] = new boolean[n][m];
        pq.add(new Pair(0, 0, 0));
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            int i = pair.i, j = pair.j, wt = pair.wt;
            if (visited[i][j])
                continue;
            visited[i][j] = true;
            ans = Math.max(ans, wt);
            if (i == n - 1 && j == m - 1)
                break;
            for (int dir[] : dirs) {
                int r = i + dir[0], c = j + dir[1];
                if (0 <= r && r < n && 0 <= c && c < m && !visited[r][c]) {
                    pq.add(new Pair(r, c, Math.max(wt, Math.abs(heights[i][j] - heights[r][c]))));
                }
            }
        }
        return ans;

    }
}