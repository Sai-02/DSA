/**
 * You are given an m x n integer matrix grid, and three integers row, col, and
 * color. Each value in the grid represents the color of the grid square at that
 * location.
 * 
 * Two squares belong to the same connected component if they have the same
 * color and are next to each other in any of the 4 directions.
 * 
 * The border of a connected component is all the squares in the connected
 * component that are either 4-directionally adjacent to a square not in the
 * component, or on the boundary of the grid (the first or last row or column).
 * 
 * You should color the border of the connected component that contains the
 * square grid[row][col] with color.
 * 
 * Return the final grid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * Output: [[3,3],[3,2]]
 * Example 2:
 * 
 * Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * Output: [[1,3,3],[2,3,3]]
 * Example 3:
 * 
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * Output: [[2,2,2],[2,1,2],[2,2,2]]
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 * Accepted
 * 23,158
 * Submissions
 * 47,647
 */

class Solution {
    int dirs[][] = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        solver(grid, row, col, color);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        return grid;
    }

    public void solver(int grid[][], int row, int col, int color) {
        int count = 0;
        grid[row][col] = -grid[row][col];
        for (int dir[] : dirs) {
            if (0 <= row + dir[0] && row + dir[0] < grid.length && 0 <= col + dir[1] && col + dir[1] < grid[0].length) {
                if (Math.abs(grid[row][col]) == Math.abs(grid[dir[0] + row][dir[1] + col])) {
                    count++;
                    if (grid[dir[0] + row][dir[1] + col] > 0)
                        solver(grid, row + dir[0], col + dir[1], color);
                }
            }
        }
        if (count == 4) {
            grid[row][col] = Math.abs(grid[row][col]);
        }
    }
}