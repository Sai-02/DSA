
/**
 * Given an integer n, return the least number of perfect square numbers that
 * sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9,
 * and 16 are perfect squares while 3 and 11 are not.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 104
 * Accepted
 * 520,852
 * Submissions
 * 1,005,144
 */
import java.util.*;

class Solution {
    public int numSquares(int n) {
        int length = (int) Math.pow(n, 0.5);
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            int val = (i + 1) * (i + 1);
            for (int j = 1; j < dp.length; j++) {
                if (val > j)
                    continue;
                else {
                    dp[j] = Math.min(dp[j], dp[j - val] + 1);
                }
            }
        }
        return dp[n];

    }
}