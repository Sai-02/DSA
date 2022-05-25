/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * Constraints:
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * Accepted
 * 474,099
 * Submissions
 * 929,491
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word2.length() + 1][word1.length() + 1];
        for (int i = word2.length(); i >= 0; i--) {
            for (int j = word1.length(); j >= 0; j--) {
                if (i == word2.length() && j == word1.length())
                    dp[i][j] = 0;
                else if (i == word2.length()) {
                    dp[i][j] = dp[i][j + 1] + 1;
                } else if (j == word1.length()) {
                    dp[i][j] = dp[i + 1][j] + 1;
                } else {
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(i);
                    if (c1 == c2)
                        dp[i][j] = dp[i + 1][j + 1];
                    else {
                        int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                        min = Math.min(min, dp[i + 1][j + 1]);
                        dp[i][j] = 1 + min;
                    }
                }
            }
        }
        return dp[0][0];
    }
}