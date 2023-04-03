
/**
 * You are given a m x n matrix grid consisting of non-negative integers where
 * grid[row][col] represents the minimum time required to be able to visit the
 * cell (row, col), which means you can visit the cell (row, col) only when the
 * time you visit it is greater than or equal to grid[row][col].
 * 
 * You are standing in the top-left cell of the matrix in the 0th second, and
 * you must move to any adjacent cell in the four directions: up, down, left,
 * and right. Each move you make takes 1 second.
 * 
 * Return the minimum time required in which you can visit the bottom-right cell
 * of the matrix. If you cannot visit the bottom-right cell, then return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
 * Output: 7
 * Explanation: One of the paths that we can take is the following:
 * - at t = 0, we are on the cell (0,0).
 * - at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <=
 * 1.
 * - at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <=
 * 2.
 * - at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <=
 * 3.
 * - at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <=
 * 4.
 * - at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <=
 * 5.
 * - at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <=
 * 6.
 * - at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <=
 * 7.
 * The final time is 7. It can be shown that it is the minimum time possible.
 * Example 2:
 * 
 * 
 * 
 * Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
 * Output: -1
 * Explanation: There is no path from the top left to the bottom-right cell.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 0 <= grid[i][j] <= 105
 * grid[0][0] == 0
 * 
 * 
 * Accepted
 * 6,326
 * Submissions
 * 17,973
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int row, col, time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        public int compareTo(Pair o) {
            return this.time - o.time;
        }
    }

    int dirs[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int row = pair.row, col = pair.col, time = pair.time;
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return time;
            }
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            for (int dir[] : dirs) {
                int r = row + dir[0], c = col + dir[1];
                if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length && !visited[r][c]) {
                    if ((time + 1) >= grid[r][c])
                        pq.add(new Pair(r, c, time + 1));
                    else {
                        int diff = grid[r][c] - time;
                        if (diff % 2 == 0) {
                            pq.add(new Pair(r, c, grid[r][c] + 1));
                        } else {
                            pq.add(new Pair(r, c, grid[r][c]));
                        }
                    }
                }
            }
        }
        return -1;
    }
}