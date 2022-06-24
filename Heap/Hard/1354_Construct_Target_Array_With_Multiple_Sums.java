
/**
 * ou are given an array target of n integers. From a starting array arr
 * consisting of n 1's, you may perform the following procedure :
 * 
 * let x be the sum of all elements currently in your array.
 * choose index i, such that 0 <= i < n and set the value of arr at index i to
 * x.
 * You may repeat this procedure as many times as needed.
 * Return true if it is possible to construct the target array from arr,
 * otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = [9,3,5]
 * Output: true
 * Explanation: Start with arr = [1, 1, 1]
 * [1, 1, 1], sum = 3 choose index 1
 * [1, 3, 1], sum = 5 choose index 2
 * [1, 3, 5], sum = 9 choose index 0
 * [9, 3, 5] Done
 * Example 2:
 * 
 * Input: target = [1,1,1,2]
 * Output: false
 * Explanation: Impossible to create target array from [1,1,1,1].
 * Example 3:
 * 
 * Input: target = [8,5]
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * n == target.length
 * 1 <= n <= 5 * 104
 * 1 <= target[i] <= 109
 * Accepted
 * 33,300
 * Submissions
 * 100,870
 */

import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int val : target) {
            pq.add(val);
            sum += val;
        }
        while (!pq.isEmpty()) {
            int val = pq.remove();
            sum -= val;
            if (val == 1 || sum == 1)
                return true;
            if (val < sum || sum == 0 || val % sum == 0)
                return false;
            val %= sum;
            sum += val;
            pq.add(val);
        }
        return true;
    }
}