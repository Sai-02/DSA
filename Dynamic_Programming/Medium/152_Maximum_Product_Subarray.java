/**
 * 152. Maximum Product Subarray
 * Medium
 * 
 * 11571
 * 
 * 357
 * 
 * Add to List
 * 
 * Share
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * Accepted
 * 747,699
 * Submissions
 * 2,161,409
 */

class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], maxEnd = nums[0], minEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxEnd;
                maxEnd = minEnd;
                minEnd = temp;
            }
            maxEnd = Math.max(nums[i], maxEnd * nums[i]);
            minEnd = Math.min(nums[i], nums[i] * minEnd);
            ans = Math.max(ans, maxEnd);
        }
        return ans;
    }
}