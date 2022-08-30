
/**
 * You are given an integer array nums. In one move, you can choose one element
 * of nums and change it by any value.
 * 
 * Return the minimum difference between the largest and smallest value of nums
 * after performing at most three moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * Example 2:
 * 
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * Accepted
 * 68,930
 * Submissions
 * 125,722
 */

import java.util.*;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 4, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            min = Math.min(min, nums[j] - nums[i]);
            j++;
            i++;
        }
        return min;
    }
}