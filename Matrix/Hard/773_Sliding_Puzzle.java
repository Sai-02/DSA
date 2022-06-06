
/**
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty
 * square represented by 0. A move consists of choosing 0 and a 4-directionally
 * adjacent number and swapping it.
 * 
 * The state of the board is solved if and only if the board is
 * [[1,2,3],[4,5,0]].
 * 
 * Given the puzzle board board, return the least number of moves required so
 * that the state of the board is solved. If it is impossible for the state of
 * the board to be solved, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Example 2:
 * 
 * 
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Example 3:
 * 
 * 
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * 
 * 
 * Constraints:
 * 
 * board.length == 2
 * board[i].length == 3
 * 0 <= board[i][j] <= 5
 * Each value board[i][j] is unique.
 * Accepted
 * 72.7K
 * Submissions
 * 114.8K
 */

import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        HashSet<String> h = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        q.add(board);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[][] a = q.remove();
                if (isTarget(a))
                    return count;
                int row = -1, col = -1;
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        if (a[i][j] == 0) {
                            row = i;
                            col = j;
                        }
                    }
                }
                for (int dir[] : dirs) {
                    if (row + dir[0] >= 0 && row + dir[0] < a.length && col + dir[1] >= 0
                            && col + dir[1] < a[0].length) {
                        a[row][col] = a[row + dir[0]][col + dir[1]];
                        a[row + dir[0]][col + dir[1]] = 0;
                        String str = getString(a);
                        if (!h.contains(str)) {
                            h.add(str);
                            int b[][] = new int[a.length][a[0].length];
                            for (int i = 0; i < a.length; i++) {
                                for (int j = 0; j < a[0].length; j++) {
                                    b[i][j] = a[i][j];
                                }
                            }
                            q.add(b);
                        }
                        a[row + dir[0]][col + dir[1]] = a[row][col];
                        a[row][col] = 0;
                    }
                }

            }
            count++;
        }
        return -1;
    }

    public String getString(int a[][]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sb.append(a[i][j] + " ");
            }
        }
        return sb.toString();
    }

    public boolean isTarget(int a[][]) {
        if (a[0][0] != 1)
            return false;
        if (a[0][1] != 2)
            return false;
        if (a[0][2] != 3)
            return false;
        if (a[1][0] != 4)
            return false;
        if (a[1][1] != 5)
            return false;
        return true;
    }
}