/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1
 * cut.
 * Example 2:
 * 
 * Input: s = "a"
 * Output: 0
 * Example 3:
 * 
 * Input: s = "ab"
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters only.
 * Accepted
 * 201,896
 * Submissions
 * 609,003
 */
class Solution {
    public int minCut(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int g = 0; g < dp.length; g++) {
            int row = 0, col = g;
            while (col < dp.length) {
                if (row == col)
                    dp[row][col] = true;
                else if (row + 1 == col)
                    dp[row][col] = (s.charAt(row) == s.charAt(col));
                else if (s.charAt(row) == s.charAt(col))
                    dp[row][col] = dp[row + 1][col - 1];
                col++;
                row++;
            }
        }
        int minPartition[] = new int[dp.length];
        for (int i = 1; i < dp.length; i++) {
            if (dp[0][i]) {
                minPartition[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i; j >= 1; j--) {
                    if (dp[j][i]) {
                        min = Math.min(min, minPartition[j - 1]);
                    }
                }
                minPartition[i] = min + 1;
            }
        }
        return minPartition[dp.length - 1];
    }
}