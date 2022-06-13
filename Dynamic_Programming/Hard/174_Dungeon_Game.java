/**
 * The demons had captured the princess and imprisoned her in the bottom-right
 * corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D
 * grid. Our valiant knight was initially positioned in the top-left room and
 * must fight his way through dungeon to rescue the princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons (represented by negative integers),
 * so the knight loses health upon entering these rooms; other rooms are either
 * empty (represented as 0) or contain magic orbs that increase the knight's
 * health (represented by positive integers).
 * 
 * To reach the princess as quickly as possible, the knight decides to move only
 * rightward or downward in each step.
 * 
 * Return the knight's minimum initial health so that he can rescue the
 * princess.
 * 
 * Note that any room can contain threats or power-ups, even the first room the
 * knight enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * Output: 7
 * Explanation: The initial health of the knight must be at least 7 if he
 * follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
 * Example 2:
 * 
 * Input: dungeon = [[0]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * m == dungeon.length
 * n == dungeon[i].length
 * 1 <= m, n <= 200
 * -1000 <= dungeon[i][j] <= 1000
 * Accepted
 * 174,704
 * Submissions
 * 476,282
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    if (dungeon[i][j] >= 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 1 + Math.abs(dungeon[i][j]);
                } else if (i == dungeon.length - 1) {
                    int need = dp[i][j + 1] - dungeon[i][j];
                    dp[i][j] = need <= 0 ? 1 : need;
                } else if (j == dungeon[0].length - 1) {
                    int need = dp[i + 1][j] - dungeon[i][j];
                    dp[i][j] = need <= 0 ? 1 : need;
                } else {
                    int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = need <= 0 ? 1 : need;
                }
            }
        }
        return dp[0][0];
    }
}