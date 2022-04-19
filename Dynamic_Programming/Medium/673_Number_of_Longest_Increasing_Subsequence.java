/**
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * Notice that the sequence has to be strictly increasing.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1,
 * 3, 5, 7].
 * Example 2:
 * 
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 * Accepted
 * 109,202
 * Submissions
 * 267,650
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        int maxLength = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 1, cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && dp[j] == max - 1)
                    cnt += count[j];
            }
            count[i] = cnt == 0 ? 1 : cnt;
            dp[i] = max;
            maxLength = Math.max(maxLength, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLength == dp[i])
                ans += count[i];
        }
        return ans;

    }
}