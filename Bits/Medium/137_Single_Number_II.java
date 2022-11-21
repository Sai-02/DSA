/**
 * Given an integer array nums where every element appears three times except
 * for one, which appears exactly once. Find the single element and return it.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * 
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which
 * appears once.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int tn = -1, tn1 = 0, tn2 = 0;
        for (int val : nums) {
            int cwtn = tn & val;
            int cwtn1 = tn1 & val;
            int cwtn2 = tn2 & val;

            tn = tn & (~cwtn);
            tn1 = tn1 | cwtn;

            tn1 = tn1 & (~cwtn1);
            tn2 = tn2 | cwtn1;

            tn2 = tn2 & (~cwtn2);
            tn = tn | cwtn2;
        }
        return tn1;
    }
}

// ==============================================================================================
//
// Pepcoding video:
// https://www.youtube.com/watch?v=3gJxLkPPW6M&ab_channel=Pepcoding
//
// ==============================================================================================