
/**
 * Given an m x n integer matrix heightMap representing the height of each unit
 * cell in a 2D elevation map, return the volume of water it can trap after
 * raining.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * Output: 4
 * Explanation: After the rain, water is trapped between the blocks.
 * We have two small ponds 1 and 3 units trapped.
 * The total volume of water trapped is 4.
 * Example 2:
 * 
 * 
 * Input: heightMap =
 * [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 * Accepted
 * 69K
 * Submissions
 * 146.8K
 */

import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int water = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            visited[i][0] = true;
            int li = heightMap[0].length - 1;
            visited[i][li] = true;
            pq.add(new Pair(i, 0, heightMap[i][0]));
            pq.add(new Pair(i, li, heightMap[i][li]));
        }
        for (int j = 0; j < heightMap[0].length; j++) {
            int li = heightMap.length - 1;
            visited[0][j] = true;
            visited[li][j] = true;
            pq.add(new Pair(0, j, heightMap[0][j]));
            pq.add(new Pair(li, j, heightMap[li][j]));
        }
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int i = pair.i, j = pair.j, height = pair.height;
            for (int[] dir : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if (row >= 0 && row < heightMap.length && col >= 0 && col < heightMap[0].length && !visited[row][col]) {
                    visited[row][col] = true;
                    if (heightMap[row][col] < height)
                        water += (height - heightMap[row][col]);
                    if (heightMap[row][col] >= height) {
                        pq.add(new Pair(row, col, heightMap[row][col]));
                    } else {
                        pq.add(new Pair(row, col, height));
                    }
                }
            }
        }
        return water;
    }

    class Pair implements Comparable<Pair> {
        int i, j, height;

        Pair(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        public int compareTo(Pair o) {
            return this.height - o.height;
        }
    }
}