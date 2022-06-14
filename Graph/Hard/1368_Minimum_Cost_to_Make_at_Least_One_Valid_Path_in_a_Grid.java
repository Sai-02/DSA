
/**
 * Given an m x n grid. Each cell of the grid has a sign pointing to the next
 * cell you should visit if you are currently in this cell. The sign of
 * grid[i][j] can be:
 * 
 * 1 which means go to the cell to the right. (i.e go from grid[i][j] to
 * grid[i][j + 1])
 * 2 which means go to the cell to the left. (i.e go from grid[i][j] to
 * grid[i][j - 1])
 * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i +
 * 1][j])
 * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i -
 * 1][j])
 * Notice that there could be some signs on the cells of the grid that point
 * outside the grid.
 * 
 * You will initially start at the upper left cell (0, 0). A valid path in the
 * grid is a path that starts from the upper left cell (0, 0) and ends at the
 * bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid
 * path does not have to be the shortest.
 * 
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a
 * cell one time only.
 * 
 * Return the minimum cost to make the grid have at least one valid path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
 * Output: 3
 * Explanation: You will start at point (0, 0).
 * The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3)
 * change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) -->
 * (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2,
 * 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
 * The total cost = 3.
 * Example 2:
 * 
 * 
 * Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
 * Output: 0
 * Explanation: You can follow the path from (0, 0) to (2, 2).
 * Example 3:
 * 
 * 
 * Input: grid = [[1,2],[4,3]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * 1 <= grid[i][j] <= 4
 * Accepted
 * 32,318
 * Submissions
 * 53,021
 */

//  Solution using 0-1 BFS

import java.util.*;

class Solution {
    class Pair {
        int i, j, cost;

        Pair(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        Deque<Pair> q = new LinkedList<>();
        q.addFirst(new Pair(0, 0, 0));
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        while (!q.isEmpty()) {
            Pair pair = q.removeFirst();
            int i = pair.i, j = pair.j;
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return pair.cost;
            }
            if (visited[i][j])
                continue;
            visited[i][j] = true;
            for (int index = 0; index < dirs.length; index++) {
                int dir[] = dirs[index];
                if (isValid(i + dir[0], j + dir[1], grid)) {
                    if (index == grid[i][j] - 1) {
                        q.addFirst(new Pair(i + dir[0], j + dir[1], pair.cost));
                    } else {
                        q.addLast(new Pair(i + dir[0], j + dir[1], pair.cost + 1));
                    }
                }
            }

        }
        return -1;
    }

    public boolean isValid(int i, int j, int grid[][]) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length)
            return true;
        return false;
    }
}