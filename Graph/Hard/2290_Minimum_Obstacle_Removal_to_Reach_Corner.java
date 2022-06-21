
/**
 * You are given a 0-indexed 2D integer array grid of size m x n. Each cell has
 * one of two values:
 * 
 * 0 represents an empty cell,
 * 1 represents an obstacle that may be removed.
 * You can move up, down, left, or right from and to an empty cell.
 * 
 * Return the minimum number of obstacles to remove so you can move from the
 * upper left corner (0, 0) to the lower right corner (m - 1, n - 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
 * Output: 2
 * Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a
 * path from (0, 0) to (2, 2).
 * It can be shown that we need to remove at least 2 obstacles, so we return 2.
 * Note that there may be other ways to remove 2 obstacles to create a path.
 * Example 2:
 * 
 * 
 * Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
 * Output: 0
 * Explanation: We can move from (0, 0) to (2, 4) without removing any
 * obstacles, so we return 0.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * grid[i][j] is either 0 or 1.
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */

import java.util.*;
//  Dijkstra Solution

class Solution {
    class Pair implements Comparable<Pair> {
        int i, j, wt;

        Pair(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        boolean visited[][] = new boolean[n][m];
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int i = pair.i, j = pair.j, wt = pair.wt;
            if (i == n - 1 && j == m - 1)
                return wt;
            if (visited[i][j])
                continue;
            visited[i][j] = true;
            for (int dir[] : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if (0 <= row && row < n && 0 <= col && col < m && !visited[row][col]) {
                    if (grid[row][col] == 1) {
                        pq.add(new Pair(row, col, wt + 1));
                    } else {
                        pq.add(new Pair(row, col, wt));
                    }
                }
            }
        }
        return -1;
    }
}

// 0-1 BFS Solution

class Solution2 {
    class Pair {
        int i, j, wt;

        Pair(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
    }

    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {
        Deque<Pair> q = new ArrayDeque<>();
        q.addFirst(new Pair(0, 0, 0));
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        while (q.size() > 0) {
            Pair pair = q.removeFirst();
            int i = pair.i, j = pair.j, wt = pair.wt;
            if (i == n - 1 && j == m - 1)
                return wt;
            if (visited[i][j])
                continue;
            visited[i][j] = true;
            for (int dir[] : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if (0 <= row && row < n && 0 <= col && col < m && !visited[row][col]) {
                    if (grid[row][col] == 1) {
                        q.addLast(new Pair(row, col, wt + 1));
                    } else {
                        q.addFirst(new Pair(row, col, wt));
                    }
                }
            }
        }
        return -1;
    }
}