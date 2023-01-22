
/**
 * Given a string s, return true if it is possible to split the string s into
 * three non-empty palindromic substrings. Otherwise, return false.​​​​​
 * 
 * A string is said to be palindrome if it the same string when reversed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcbdd"
 * Output: true
 * Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are
 * palindromes.
 * Example 2:
 * 
 * Input: s = "bcbddxy"
 * Output: false
 * Explanation: s cannot be split into 3 palindromes.
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 2000
 * s​​​​​​ consists only of lowercase English letters.
 * Accepted
 * 18,692
 * Submissions
 * 40,959
 */

class Solution {
    public boolean checkPartitioning(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int g = 0; g < dp.length; g++) {
            int row = 0, col = g;
            while (col < dp.length) {
                if (row == col)
                    dp[row][col] = true;
                else if (col == row + 1) {
                    dp[row][col] = (s.charAt(row) == s.charAt(col));
                } else {
                    if (s.charAt(row) == s.charAt(col)) {
                        dp[row][col] = dp[row + 1][col - 1];
                    }
                }
                col++;
                row++;
            }
        }
        return solver(s, 0, s.length(), 3, dp);
    }

    public boolean solver(String s, int start, int end, int parts, boolean dp[][]) {
        if (parts == 1) {
            if (start >= s.length())
                return false;
            if (dp[start][end - 1])
                return true;
            else
                return false;
        }
        for (int i = start; i < end; i++) {
            if (dp[start][i]) {
                if (solver(s, i + 1, s.length(), parts - 1, dp))
                    return true;
            }
        }
        return false;
    }
}