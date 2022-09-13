
/**
 * There is a 1 million by 1 million grid on an XY-plane, and the coordinates of
 * each grid square are (x, y).
 * 
 * We start at the source = [sx, sy] square and want to reach the target = [tx,
 * ty] square. There is also an array of blocked squares, where each blocked[i]
 * = [xi, yi] represents a blocked square with coordinates (xi, yi).
 * 
 * Each move, we can walk one square north, east, south, or west if the square
 * is not in the array of blocked squares. We are also not allowed to walk
 * outside of the grid.
 * 
 * Return true if and only if it is possible to reach the target square from the
 * source square through a sequence of valid moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * Output: false
 * Explanation: The target square is inaccessible starting from the source
 * square because we cannot move.
 * We cannot move north or east because those squares are blocked.
 * We cannot move south or west because we cannot go outside of the grid.
 * Example 2:
 * 
 * Input: blocked = [], source = [0,0], target = [999999,999999]
 * Output: true
 * Explanation: Because there are no blocked cells, it is possible to reach the
 * target square.
 * 
 * 
 * Constraints:
 * 
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * It is guaranteed that source and target are not blocked.
 * Accepted
 * 16,721
 * Submissions
 * 49,016
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 * Problems
 * 
 */

import java.util.*;

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        int max = (int) Math.pow(10, 6);
        HashSet<String> h = new HashSet<>();
        for (int b[] : blocked) {
            h.add(b[0] + " " + b[1]);
        }
        int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int count = 0, block = 0;
        for (int dir[] : dirs) {
            int x = target[0] + dir[0], y = target[1] + dir[1];
            if (0 <= x && x < max && 0 <= y && y < max) {
                count++;
                if (h.contains(x + " " + y))
                    block++;
            }
        }
        if (count == block)
            return false;
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty() && q.size() < 400) {
            int size = q.size();
            while (size-- > 0) {
                int src[] = q.remove();
                for (int dir[] : dirs) {
                    int x = src[0] + dir[0], y = src[1] + dir[1];
                    if (0 <= x && x < max && 0 <= y && y < max && !h.contains(x + " " + y)) {
                        if (x == target[0] && y == target[1])
                            return true;
                        int node[] = new int[2];
                        node[0] = x;
                        node[1] = y;
                        q.add(node);
                        h.add(x + " " + y);
                    }
                }
            }
        }
        if (q.size() >= 400)
            return true;
        return false;
    }

}