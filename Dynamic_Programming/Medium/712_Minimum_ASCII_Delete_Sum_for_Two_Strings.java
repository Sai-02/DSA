/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted
 * characters to make two strings equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the
 * sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum
 * possible to achieve this.
 * Example 2:
 * 
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d] + 101[e] + 101[e] to the sum.
 * Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is
 * 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers
 * of 433 or 417, which are higher.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 1000
 * s1 and s2 consist of lowercase English letters.
 * Accepted
 * 62,778
 * Submissions
 * 101,945
 */

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() && j == s2.length()) {
                    dp[i][j] = 0;
                } else if (i == s1.length()) {
                    dp[i][j] = dp[i][j + 1] + s2.charAt(j);
                } else if (j == s2.length()) {
                    dp[i][j] = dp[i + 1][j] + s1.charAt(i);
                } else {
                    if (s1.charAt(i) == s2.charAt(j))
                        dp[i][j] = dp[i + 1][j + 1];
                    else {
                        dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
                    }

                }
            }
        }
        return dp[0][0];
    }
}