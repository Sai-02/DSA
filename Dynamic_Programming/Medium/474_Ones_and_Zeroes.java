/**
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the
 * maximum of 3.
 * Example 2:
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= strs.length; i++) {
            int nums[] = new int[] { 0, 0 };
            if (i > 0) {
                nums = analyze(strs[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0)
                        dp[i][j][k] = 0;
                    else if (j >= nums[0] && k >= nums[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];

    }

    public static int[] analyze(String str) {
        int ans[] = new int[2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0')
                ans[0]++;
            else
                ans[1]++;
        }
        return ans;
    }
}