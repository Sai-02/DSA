
/**
 * here is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * 
 * The island is partitioned into a grid of square cells. You are given an m x n
 * integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 * 
 * The island receives a lot of rain, and the rain water can flow to neighboring
 * cells directly north, south, east, and west if the neighboring cell's height
 * is less than or equal to the current cell's height. Water can flow from any
 * cell adjacent to an ocean into the ocean.
 * 
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
 * Atlantic oceans.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heights =
 * [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans,
 * as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 * [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 * [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 * [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 * [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 * [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 * [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 * [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the
 * Pacific and Atlantic oceans.
 * Example 2:
 * 
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and
 * Atlantic oceans.
 * 
 * 
 * Constraints:
 * 
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 * Accepted
 * 277,698
 * Submissions
 * 524,220
 */

import java.util.*;

class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean atlantic[][] = new boolean[heights.length][heights[0].length];
        boolean pacific[][] = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, heights[0].length - 1, heights, atlantic);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(0, j, heights, pacific);
            dfs(heights.length - 1, j, heights, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int row, int col, int heights[][], boolean visited[][]) {
        if (visited[row][col])
            return;
        visited[row][col] = true;
        for (int dir[] : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if (0 <= nr && nr < visited.length && 0 <= nc && nc < visited[0].length
                    && heights[row][col] <= heights[nr][nc]) {
                dfs(nr, nc, heights, visited);
            }
        }

    }
}