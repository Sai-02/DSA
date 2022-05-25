/**
 * Given two strings. The task is to find the length of the longest common
 * substring.
 * 
 * 
 * Example 1:
 * 
 * Input: S1 = "ABCDGH", S2 = "ACDGHR"
 * Output: 4
 * Explanation: The longest common substring
 * is "CDGH" which has length 4.
 * Example 2:
 * 
 * Input: S1 = "ABC", S2 "ACB"
 * Output: 1
 * Explanation: The longest common substrings
 * are "A", "B", "C" all having length 1.
 * 
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the
 * function longestCommonSubstr() which takes the string S1, string S2 and their
 * length n and m as inputs and returns the length of the longest common
 * substring in S1 and S2.
 * 
 * 
 * Expected Time Complexity: O(n*m).
 * Expected Auxiliary Space: O(n*m).
 * 
 * 
 * Constraints:
 * 1<=n, m<=1000
 * 
 */

class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        int max = 0;
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n | j == m)
                    dp[i][j] = 0;
                else if (S1.charAt(i) == S2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}