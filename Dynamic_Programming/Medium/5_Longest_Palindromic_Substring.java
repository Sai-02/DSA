/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int startIndex = 0, endIndex = 0;
        for (int gap = 0; gap < dp.length; gap++) {
            int row = 0, col = gap;
            while (col < dp.length) {
                if (row == col)
                    dp[row][col] = true;
                else if (col == row + 1) {
                    if (s.charAt(row) == s.charAt(col))
                        dp[row][col] = true;
                } else {
                    if (s.charAt(row) == s.charAt(col)) {
                        dp[row][col] = dp[row + 1][col - 1];
                    }
                }
                if (dp[row][col]) {
                    startIndex = row;
                    endIndex = col;
                }
                row++;
                col++;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}