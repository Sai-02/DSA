
/**
 * Given an integer array nums, you need to find one continuous subarray that if
 * you only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
 * whole array sorted in ascending order.
 * Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 * 
 * Input: nums = [1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 
 * 
 * Follow up: Can you solve it in O(n) time complexity?
 */
import java.util.*;
//  ===========================================
// 
//  Naive Solution
// 
// ===========================================

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int qb[] = new int[n];
        for (int i = 0; i < n; i++)
            qb[i] = nums[i];
        Arrays.sort(qb);
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (qb[i] != nums[i]) {
                start = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (qb[i] != nums[i]) {
                end = i;
                break;
            }
        }
        if (end == -1 && start == -1)
            return 0;
        return end - start + 1;
    }
}

// ======================================
//
// Optimized Solution
//
// ======================================

class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (max > nums[i])
                end = i;
            max = Math.max(max, nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (min < nums[i])
                start = i;
            min = Math.min(min, nums[i]);
        }
        if (start == -1 && end == -1)
            return 0;
        return end - start + 1;

    }
}