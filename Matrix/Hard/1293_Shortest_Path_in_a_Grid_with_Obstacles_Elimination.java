
/**
 * You are given an m x n integer matrix grid where each cell is either 0
 * (empty) or 1 (obstacle). You can move up, down, left, or right from and to an
 * empty cell in one step.
 * 
 * Return the minimum number of steps to walk from the upper left corner (0, 0)
 * to the lower right corner (m - 1, n - 1) given that you can eliminate at most
 * k obstacles. If it is not possible to find such walk return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such
 * path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * Example 2:
 * 
 * 
 * Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
 * Output: -1
 * Explanation: We need to eliminate at least two obstacles to find such a walk.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 40
 * 1 <= k <= m * n
 * grid[i][j] is either 0 or 1.
 * grid[0][0] == grid[m - 1][n - 1] == 0
 * Accepted
 * 107,564
 * Submissions
 * 246,844
 */

//   Hint : Simple BFS

import java.util.*;

class Solution {
    class Pair {
        int i, j, steps;

        Pair(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }

    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        int count = 0;
        int dp[][] = new int[m][n];
        for (int a[] : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair pair = q.remove();
                int i = pair.i, j = pair.j, steps = pair.steps;
                if (i == m - 1 && j == n - 1)
                    return count;
                for (int dir[] : dirs) {
                    int row = i + dir[0], col = j + dir[1];
                    if (0 <= row && row < m && 0 <= col && col < n) {
                        int st = grid[row][col] + steps;
                        if (st >= dp[row][col] || st > k)
                            continue;
                        dp[row][col] = st;
                        q.add(new Pair(row, col, st));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}