
/**
 * Given an array nums of integers, return the length of the longest arithmetic
 * subsequence in nums.
 * 
 * Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ...,
 * nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence
 * seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i <
 * seq.length - 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 * 
 * Input: nums = [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 * 
 * Input: nums = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * Accepted
 * 93,322
 * Submissions
 * 196,927
 */

import java.util.*;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, max = 0;
        ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>();
        dp.add(new HashMap<Integer, Integer>());
        for (int i = 1; i < nums.length; i++) {
            dp.add(new HashMap<Integer, Integer>());
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                if (dp.get(i).containsKey(diff))
                    continue;
                if (dp.get(j).containsKey(diff)) {
                    dp.get(i).put(diff, dp.get(j).get(diff) + 1);
                } else {
                    dp.get(i).put(diff, 2);
                }
                max = Math.max(max, dp.get(i).get(diff));
            }
        }

        return max;
    }
}