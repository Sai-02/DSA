
/**
 * The median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle values.
 * 
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding
 * window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 * 
 * Return the median array for each window in the original array. Answers within
 * 10-5 of the actual value will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation:
 * Window position Median
 * --------------- -----
 * [1 3 -1] -3 5 3 6 7 1
 * 1 [3 -1 -3] 5 3 6 7 -1
 * 1 3 [-1 -3 5] 3 6 7 -1
 * 1 3 -1 [-3 5 3] 6 7 3
 * 1 3 -1 -3 [5 3 6] 7 5
 * 1 3 -1 -3 5 [3 6 7] 6
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * Accepted
 * 105,194
 * Submissions
 * 256,641
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (low.size() <= high.size()) {
                high.add(nums[i]);
                low.add(high.remove());
            } else {
                low.add(nums[i]);
                high.add(low.remove());
            }
            if (low.size() + high.size() == k) {
                if (low.size() == high.size()) {

                    ans[index++] = (double) ((long) high.peek() + (long) (low.peek())) / 2.00000;
                } else
                    ans[index++] = low.peek() / 1.00000;

                int ri = i - k + 1;
                if (low.contains(nums[ri]))
                    low.remove(nums[ri]);
                else
                    high.remove(nums[ri]);
            }
        }
        return ans;
    }
}