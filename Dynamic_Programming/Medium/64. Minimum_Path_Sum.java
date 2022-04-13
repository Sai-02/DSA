/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * 
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] += grid[i][j];
                int min = Integer.MAX_VALUE;
                if (j + 1 < m)
                    min = Math.min(min, dp[i][j + 1]);
                if (i + 1 < n)
                    min = Math.min(min, dp[i + 1][j]);
                if (min != Integer.MAX_VALUE)
                    dp[i][j] += min;
            }
        }
        return dp[0][0];
    }
}

// ================================================================================
//
// We can further optimize above solution by removing this extra dp array
//
// ==================================================================================

class Solution2 {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                if (j + 1 < m)
                    min = Math.min(min, grid[i][j + 1]);
                if (i + 1 < n)
                    min = Math.min(min, grid[i + 1][j]);
                if (min != Integer.MAX_VALUE)
                    grid[i][j] += min;
            }
        }
        return grid[0][0];
    }
}
