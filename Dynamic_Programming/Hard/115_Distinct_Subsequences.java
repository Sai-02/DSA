/**
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * A string's subsequence is a new string formed from the original string by
 * deleting some (can be none) of the characters without disturbing the
 * remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 * 
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 * Accepted
 * 240,168
 * Submissions
 * 558,027
 */

class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (j == dp[0].length - 1)
                    dp[i][j] = 1;
                else if (i == dp.length - 1)
                    dp[i][j] = 0;
                else {
                    if (s.charAt(i) == t.charAt(j) && dp[i + 1][j + 1] > 0) {
                        dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}