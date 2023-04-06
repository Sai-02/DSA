/*
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal
 * 4-directionally connected group of 0s and a closed island is an island
 * totally (all left, top, right, bottom) surrounded by 1s.
 * 
 * Return the number of closed islands.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1
 * ,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water
 * (group of 1s).
 * Example 2:
 * 
 * 
 * 
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 * 
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * Accepted
 * 146,141
 * Submissions
 * 224,207
 */

class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int grid[][], int row, int col) {
        if (grid[row][col] == 2) {
            if (0 == row || col == 0 || row == grid.length - 1 || col == grid[0].length - 1)
                return false;
            return true;
        }
        grid[row][col] = 2;
        boolean ans = true;
        for (int dir[] : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length) {
                if (grid[newRow][newCol] > 0) {
                } else {
                    if (!dfs(grid, newRow, newCol))
                        ans = false;
                }
            } else
                ans = false;
        }
        return ans;

    }
}
