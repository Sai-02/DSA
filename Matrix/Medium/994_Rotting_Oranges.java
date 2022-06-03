
/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never
 * rotten, because rotting only happens 4-directionally.
 * Example 3:
 * 
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer
 * is just 0.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 * Accepted
 * 395,175
 * Submissions
 * 762,84
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

    int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        int count = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair pair = q.remove();
                int row = pair.row, col = pair.col;
                for (int dir[] : dirs) {
                    if (row + dir[0] >= 0 && row + dir[0] < grid.length && col + dir[1] >= 0
                            && col + dir[1] < grid[0].length) {
                        if (grid[row + dir[0]][col + dir[1]] == 2 || grid[row + dir[0]][col + dir[1]] == 0)
                            continue;
                        q.add(new Pair(row + dir[0], col + dir[1]));
                        grid[row + dir[0]][col + dir[1]] = 2;
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return count == 0 ? 0 : count - 1;

    }
}