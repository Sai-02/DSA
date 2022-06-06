
/**
 * You are given an n x n binary matrix grid where 1 represents land and 0
 * represents water.
 * 
 * An island is a 4-directionally connected group of 1's not connected to any
 * other 1's. There are exactly two islands in grid.
 * 
 * You may change 0's to 1's to connect the two islands to form one island.
 * 
 * Return the smallest number of 0's you must flip to connect the two islands.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * 
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * 
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] is either 0 or 1.
 * There are exactly two islands in grid.
 */
import java.util.*;

class Solution {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int dirs[][] = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public int shortestBridge(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            boolean shouldBreak = false;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    solver(grid, i, j, q);
                    shouldBreak = true;
                    break;
                }
            }
            if (shouldBreak)
                break;
        }
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.remove();
                int row = p.row, col = p.col;
                for (int dir[] : dirs) {
                    if (row + dir[0] >= 0 && row + dir[0] < grid.length && col + dir[1] >= 0
                            && col + dir[1] < grid[0].length) {
                        if (grid[row + dir[0]][col + dir[1]] == 1)
                            return count;
                        else if (grid[row + dir[0]][col + dir[1]] == 0) {
                            grid[row + dir[0]][col + dir[1]] = 2;
                            q.add(new Pair(row + dir[0], col + dir[1]));
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public void solver(int grid[][], int row, int col, Queue<Pair> q) {
        if (grid[row][col] == 0 || grid[row][col] == 2)
            return;
        grid[row][col] = 2;
        q.add(new Pair(row, col));
        for (int dir[] : dirs) {
            if (row + dir[0] >= 0 && row + dir[0] < grid.length && col + dir[1] >= 0 && col + dir[1] < grid[0].length) {
                solver(grid, row + dir[0], col + dir[1], q);
            }
        }
    }
}