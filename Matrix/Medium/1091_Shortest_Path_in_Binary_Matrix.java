
/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
Accepted
336,191
Submissions
734,986
 */

import java.util.*;

class Solution {
    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int dirs[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 1)
            return -1;
        q.add(new Pair(0, 0));
        visited[0][0] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair pair = q.remove();
                if (pair.i == grid.length - 1 && pair.j == grid[0].length - 1)
                    return count + 1;
                for (int dir[] : dirs) {
                    int row = pair.i + dir[0], col = pair.j + dir[1];
                    if (0 <= row && row < grid.length && 0 <= col && col < grid[0].length && !visited[row][col]
                            && grid[row][col] == 0) {
                        q.add(new Pair(row, col));
                        visited[row][col] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}