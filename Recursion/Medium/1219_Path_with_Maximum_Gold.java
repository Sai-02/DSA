/**
 * n a gold mine grid of size m x n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 * 
 * Return the maximum amount of gold you can collect under the conditions:
 * 
 * Every time you are located in a cell you will collect all the gold in that
 * cell.
 * From your position, you can walk one step to the left, right, up, or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has
 * some gold.
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * [5,8,7],
 * [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * Example 2:
 * 
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * [2,0,6],
 * [3,4,5],
 * [0,3,0],
 * [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 * Accepted
 * 87.6K
 * Submissions
 * 134.5K
 */

class Solution {
    int max = 0;
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    dfs(grid, i, j, 0);
            }
        }
        return max;
    }

    public void dfs(int grid[][], int row, int col, int profit) {
        profit += grid[row][col];
        int val = grid[row][col];
        grid[row][col] = 0;
        boolean end = true;
        for (int dir[] : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length
                    && grid[newRow][newCol] > 0) {
                end = false;
                dfs(grid, newRow, newCol, profit);
            }
        }
        if (end) {
            max = Math.max(max, profit);
        }
        grid[row][col] = val;
    }
}