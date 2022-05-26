/**
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make
 * "eat" to "ea".
 * Example 2:
 * 
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = word1.length(); i >= 0; i--) {
            for (int j = word2.length(); j >= 0; j--) {
                if (i == word1.length() && j == word2.length()) {
                    dp[i][j] = 0;
                } else if (i == word1.length()) {
                    dp[i][j] = 1 + dp[i][j + 1];
                } else if (j == word2.length()) {
                    dp[i][j] = 1 + dp[i + 1][j];
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}