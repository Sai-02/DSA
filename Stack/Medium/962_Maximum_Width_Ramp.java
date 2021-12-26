
/**
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i]
 * <= nums[j]. The width of such a ramp is j - i.
 * 
 * Given an integer array nums, return the maximum width of a ramp in nums. If
 * there is no ramp in nums, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] =
 * 0 and nums[5] = 5.
 * Example 2:
 * 
 * Input: nums = [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] =
 * 1 and nums[9] = 1.
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5 * 104
 * Accepted
 * 30,329
 * Submissions
 * 63,645
 */
import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (st.empty() || nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }
        int maxWidth = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - st.peek());
                st.pop();
            }
        }
        return maxWidth;
    }
}