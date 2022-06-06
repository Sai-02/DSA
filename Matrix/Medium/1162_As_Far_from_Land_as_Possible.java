
/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized, and return the distance. If no land or water
 * exists in the grid, return -1.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with
 * distance 2.
 * Example 2:
 * 
 * 
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with
 * distance 4.
 * 
 * 
 * Constraints:
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 * Accepted
 * 63,134
 * Submissions
 * 131,296
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

    public int maxDistance(int[][] grid) {
        int water = 0, land = 0;
        int dirs[][] = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    land++;
                } else
                    water++;
            }
        }
        if (water == 0 || land == 0)
            return -1;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.remove();
                int row = p.row, col = p.col;
                for (int dir[] : dirs) {
                    if (row + dir[0] >= 0 && row + dir[0] < grid.length && col + dir[1] >= 0
                            && col + dir[1] < grid[0].length) {
                        if (grid[row + dir[0]][col + dir[1]] == 0) {
                            grid[row + dir[0]][col + dir[1]] = 1;
                            q.add(new Pair(row + dir[0], col + dir[1]));
                        }
                    }
                }
            }
            count++;
        }
        return count - 1;
    }
}