/**
 * You are given a string s and a positive integer k.
 * 
 * Select a set of non-overlapping substrings from the string s that satisfy the
 * following conditions:
 * 
 * The length of each substring is at least k.
 * Each substring is a palindrome.
 * Return the maximum number of substrings in an optimal selection.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abaccdbbd", k = 3
 * Output: 2
 * Explanation: We can select the substrings underlined in s = "abaccdbbd". Both
 * "aba" and "dbbd" are palindromes and have a length of at least k = 3.
 * It can be shown that we cannot find a selection with more than two valid
 * substrings.
 * Example 2:
 * 
 * Input: s = "adbcda", k = 2
 * Output: 0
 * Explanation: There is no palindrome substring of length at least 2 in the
 * string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= s.length <= 2000
 * s consists of lowercase English letters.
 */

class Solution {

    public int maxPalindromes(String s, int k) {
        if (k == 1)
            return s.length();
        boolean dp[][] = new boolean[s.length() + 1][s.length() + 1];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i + k <= s.length(); i++) {
            if (dp[i][i + k - 1] || dp[i][i + k])
                res++;
            i += dp[i][i + k - 1] ? k - 1 : dp[i][i + k] ? k : 0;
        }
        return res;
    }
}

// Catch is to figure out that we only have to consider substrings of length k
// and k+1