/**
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * Follow up:
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * Accepted
 * 882,011
 * Submissions
 * 1,497,910
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid + 1)
                    count++;
            }
            if (count > mid + 1) {
                ans = mid + 1;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}