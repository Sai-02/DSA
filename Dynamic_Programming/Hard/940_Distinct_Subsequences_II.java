
/**
 * Given a string s, return the number of distinct non-empty subsequences of s.
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc",
 * and "abc".
 * Example 2:
 * 
 * Input: s = "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and
 * "aba".
 * Example 3:
 * 
 * Input: s = "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters.
 * Accepted
 * 27,198
 * Submissions
 * 61,338
 */
import java.util.*;

class Solution {
    public int distinctSubseqII(String s) {
        long mod = (long) Math.pow(10, 9) + 7;
        long dp[] = new long[s.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            dp[i] = (2L * (dp[i - 1] % mod)) % mod;
            if (hm.containsKey(c)) {
                dp[i] = (dp[i] % mod) - (dp[hm.get(c) - 1] % mod) + mod;
            }
            dp[i] %= mod;
            hm.put(c, i);
        }
        return (int) ((dp[dp.length - 1] - 1L) % mod);
    }
}