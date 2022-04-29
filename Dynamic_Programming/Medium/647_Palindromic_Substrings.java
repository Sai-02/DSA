/**
 * Medium
 * 
 * 6193
 * 
 * 154
 * 
 * Add to List
 * 
 * Share
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * Accepted
 * 400,853
 * Submissions
 * 620,375
 */

class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
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
                if (dp[row][col])
                    count++;
                row++;
                col++;
            }
        }
        return count;
    }
}