
/**
 * Given an integer array nums and an integer k, return the length of the
 * shortest non-empty subarray of nums with a sum of at least k. If there is no
 * such subarray, return -1.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1], k = 1
 * Output: 1
 * Example 2:
 * 
 * Input: nums = [1,2], k = 4
 * Output: -1
 * Example 3:
 * 
 * Input: nums = [2,-1,2], k = 3
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 */

import java.util.*;

class Solution {
    class Pair {
        int index;
        long sum;

        Pair(int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> dq = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k)
                minLength = Math.min(minLength, i + 1);
            while (dq.size() > 0 && sum - dq.peekFirst().sum >= k) {
                minLength = Math.min(minLength, i - dq.peekFirst().index);
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dq.peekLast().sum >= sum) {
                dq.removeLast();
            }
            dq.addLast(new Pair(i, sum));
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;

    }
}