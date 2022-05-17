
/**
 * You are given an integer array nums that is sorted in non-decreasing order.
 * 
 * Determine if it is possible to split nums into one or more subsequences such
 * that both of the following conditions are true:
 * 
 * Each subsequence is a consecutive increasing sequence (i.e. each integer is
 * exactly one more than the previous integer).
 * All subsequences have a length of 3 or more.
 * Return true if you can split nums according to the above conditions, or false
 * otherwise.
 * 
 * A subsequence of an array is a new array that is formed from the original
 * array by deleting some (can be none) of the elements without disturbing the
 * relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence
 * of [1,2,3,4,5] while [1,3,2] is not).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,3,4,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,5] --> 1, 2, 3
 * [1,2,3,3,4,5] --> 3, 4, 5
 * Example 2:
 * 
 * Input: nums = [1,2,3,3,4,4,5,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
 * [1,2,3,3,4,4,5,5] --> 3, 4, 5
 * Example 3:
 * 
 * Input: nums = [1,2,3,4,4,5]
 * Output: false
 * Explanation: It is impossible to split nums into consecutive increasing
 * subsequences of length 3 or more.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * nums is sorted in non-decreasing order.
 */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int left, right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;

        }

        public int compareTo(Pair o) {
            if (o.right == this.right) {
                return (this.right - this.left) - (o.right - o.left);
            }
            return this.right - o.right;
        }
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int num : nums) {
            while (pq.size() > 0 && pq.peek().right + 1 < num) {
                Pair pair = pq.remove();
                if (pair.right - pair.left + 1 < 3)
                    return false;
            }
            if (pq.isEmpty() || pq.peek().right == num)
                pq.add(new Pair(num, num));
            else {
                Pair pair = pq.remove();
                pq.add(new Pair(pair.left, num));
            }
        }
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (pair.right - pair.left + 1 < 3)
                return false;
        }
        return true;
    }
}