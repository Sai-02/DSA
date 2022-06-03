
/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
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

    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    q.add(new Pair(i, j));
                else
                    mat[i][j] = -1;
            }
        }
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int i = pair.i, j = pair.j;
            if (i - 1 >= 0 && mat[i - 1][j] == -1) {
                mat[i - 1][j] = 1 + mat[i][j];
                q.add(new Pair(i - 1, j));
            }
            if (i + 1 < mat.length && mat[i + 1][j] == -1) {
                mat[i + 1][j] = 1 + mat[i][j];
                q.add(new Pair(i + 1, j));
            }
            if (j - 1 >= 0 && mat[i][j - 1] == -1) {
                mat[i][j - 1] = 1 + mat[i][j];
                q.add(new Pair(i, j - 1));
            }
            if (j + 1 < mat[0].length && mat[i][j + 1] == -1) {
                mat[i][j + 1] = 1 + mat[i][j];
                q.add(new Pair(i, j + 1));
            }
        }
        return mat;
    }
}