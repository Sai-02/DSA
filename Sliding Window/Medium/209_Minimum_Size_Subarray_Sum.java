/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If there
 * is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * Example 2:
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

// Solution Using Binary Search O(nlogn)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        if (sum[0] >= target)
            return 1;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (nums[i] >= target)
                return 1;
            if (sum[i] >= target)
                minLength = Math.min(minLength, i + 1);
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            int l = 0, r = k - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                int val = sum[k] - sum[mid];
                if (val >= target) {
                    minLength = Math.min(k - mid, minLength);
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

// Sliding Window Solution O(n)

class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0, minLength = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sum >= target) {
                minLength = Math.min(minLength, j - i);
                sum -= nums[i++];
            } else {
                sum += nums[j++];
            }
        }
        while (sum >= target && i <= j) {
            minLength = Math.min(minLength, j - i);
            sum -= nums[i++];
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}