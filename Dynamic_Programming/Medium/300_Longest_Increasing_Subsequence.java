
/**
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements. For
 * example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 * length is 4.
 * Example 2:
 * 
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * 
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 */
import java.util.*;
// =================================================================
//
// DP solution TC- O(n2) SC-O(n)
//
// ===================================================================

class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int maxCount = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }
}

// ==================================================================
//
// Solution using Binary Search TC-O(nlogn)
//
// ==================================================================

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > a.get(a.size() - 1))
                a.add(nums[i]);
            else {
                int l = 0, r = a.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (a.get(mid) == nums[i]) {
                        l = mid;
                        break;
                    } else if (a.get(mid) > nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                a.set(l, nums[i]);
            }
        }
        return a.size();
    }
}