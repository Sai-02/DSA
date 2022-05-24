/**
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * 
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
 * by repeating 'a' once, it becomes "aa".
 * Example 3:
 * 
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * Accepted
 * 684,662
 * Submissions
 * 2,422,863
 */

class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[p.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*')
                        dp[i][j] = dp[i - 2][j];
                } else {
                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);
                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];
                        if (p.charAt(i - 2) == '.' || p.charAt(i - 2) == sc) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }
                    } else if (pc == '.' || pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}