
/**
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can pick two numbers from the array whose sum equals k
 * and remove them from the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 * 
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */
import java.util.*;
// ================================================================
//
// HashMap Approach TC-O(n) SC-O(n)
//
// ==================================================================

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        for (int val : nums) {
            if (hm.containsKey(val)) {
                if (k - val == val) {
                    if (hm.get(val) > 1) {
                        count++;
                        if (hm.get(val) == 0)
                            hm.remove(val);
                        else
                            hm.put(val, hm.get(val) - 2);
                    }
                } else {
                    if (hm.containsKey(k - val)) {
                        count++;
                        if (hm.get(k - val) == 1)
                            hm.remove(k - val);
                        else
                            hm.put(k - val, hm.get(k - val) - 1);
                        if (hm.get(val) == 1)
                            hm.remove(val);
                        else
                            hm.put(val, hm.get(val) - 1);
                    }
                }
            }
        }
        return count;
    }
}

// ========================================================
//
// Sorting and Two Pointer TC-O(nlogn) SC-O(1)
//
// =========================================================

class Solution2 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                count++;
                l++;
                r--;
            } else if (sum < k)
                l++;
            else
                r--;
        }
        return count;
    }
}