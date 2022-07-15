/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected
 * 4-directionally.
 * Example 2:
 * 
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * Accepted
 * 515,368
 * Submissions
 * 732,515
 */

class Solution {
    static int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxCount = Math.max(maxCount, dfs(grid, i, j));
                }
            }
        }
        return maxCount;
    }

    public static int dfs(int grid[][], int row, int col) {
        if (grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        int count = 1;
        for (int dir[] : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length) {
                count += dfs(grid, newRow, newCol);
            }
        }
        return count;

    }
}