/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
 * if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * Example 2:
 * 
 * Input: nums = [1,5]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * Accepted
 * 184,881
 * Submissions
 * 328,338
 */

class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int l = 1, r = 1;
                    if (i != 0)
                        l = nums[i - 1];
                    if (j != nums.length - 1)
                        r = nums[j + 1];
                    int before = 0, after = 0;
                    if (k != i) {
                        before = dp[i][k - 1];
                    }
                    if (k != j)
                        after = dp[k + 1][j];
                    max = Math.max(max, before + after + (l * r * nums[k]));
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp.length - 1];
    }
}