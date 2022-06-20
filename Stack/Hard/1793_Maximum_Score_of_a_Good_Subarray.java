/**
 * You are given an array of integers nums (0-indexed) and an integer k.
 * 
 * The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ...,
 * nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.
 * 
 * Return the maximum possible score of a good subarray.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,3,7,4,5], k = 3
 * Output: 15
 * Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) *
 * (5-1+1) = 3 * 5 = 15.
 * Example 2:
 * 
 * Input: nums = [5,5,4,5,4,1,1,1], k = 0
 * Output: 20
 * Explanation: The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) *
 * (4-0+1) = 4 * 5 = 20.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 104
 * 0 <= k < nums.length
 * Accepted
 * 14,721
 * Submissions
 * 28,232
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */

//  Hint : Application of Largest Area of Histogram
import java.util.*;

class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            while (!st.empty() && nums[st.peek()] > nums[i]) {
                int h = nums[st.pop()];
                if ((st.empty() || st.peek() < k) && i > k) {
                    int area = h * (i - (st.empty() ? -1 : st.peek()) - 1);
                    ans = Math.max(ans, area);
                }

            }
            st.push(i);
        }
        while (!st.empty()) {
            int h = nums[st.pop()];
            int i = nums.length;
            if ((st.empty() || st.peek() < k)) {
                int area = h * (i - (st.empty() ? -1 : st.peek()) - 1);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}