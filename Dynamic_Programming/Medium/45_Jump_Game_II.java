/**
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * 
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */

// ========================================================================
//
// DP solution using tabulation TC-O(n2) SC-O(n)
//
// =========================================================================

class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0)
                dp[i] = -1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        if (dp[i + j] != -1) {
                            min = Math.min(dp[i + j], min);
                        }
                    }
                    if (min == Integer.MAX_VALUE)
                        dp[i] = -1;
                    else
                        dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}

// =======================================================
//
// Greedy Solution TC-O(N) Sc-O(1)
//
// =======================================================

class Solution2 {
    public int jump(int[] nums) {
        int maxReachable = 0, lastJumpPos = 0, jumps = 0, i = 0;
        while (lastJumpPos < nums.length - 1) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == lastJumpPos) {
                lastJumpPos = maxReachable;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
}