
/**
 * Hard
 * 
 * 2958
 * 
 * 347
 * 
 * Add to List
 * 
 * Share
 * Given an integer array nums, return the maximum difference between two
 * successive elements in its sorted form. If the array contains less than two
 * elements, return 0.
 * 
 * You must write an algorithm that runs in linear time and uses linear extra
 * space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9)
 * has the maximum difference 3.
 * Example 2:
 * 
 * Input: nums = [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */

import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : nums) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        if (max == min)
            return 0;
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int bucketMin[] = new int[nums.length];
        int bucketMax[] = new int[nums.length];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int val : nums) {
            if (val == min || val == max)
                continue;
            int index = (val - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], val);
            bucketMax[index] = Math.max(bucketMax[index], val);
        }
        int maxGap = 0, prev = min;
        for (int i = 0; i < nums.length; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE || bucketMax[i] == Integer.MIN_VALUE)
                continue;
            else {
                maxGap = Math.max(maxGap, bucketMin[i] - prev);
                prev = bucketMax[i];
            }
        }
        maxGap = Math.max(maxGap, max - prev);
        return maxGap;

    }
}