/**
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * Example 3:
 * 
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 */

class Solution {
    public int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int val : nums) {
            high += val;
            low = Math.max(low, val);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPossible(int nums[], int capacity, int m) {
        int count = 1, sum = 0;
        for (int val : nums) {
            if (val + sum <= capacity) {
                sum += val;
            } else {
                count++;
                sum = val;
            }
        }
        if (count > m)
            return false;
        return true;
    }
}