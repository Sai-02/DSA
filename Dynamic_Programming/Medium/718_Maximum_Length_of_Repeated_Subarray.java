/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * Example 2:
 * 
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * Accepted
 * 224,654
 * Submissions
 * 435,608
 */

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        int maxLength = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] != nums2[j])
                    continue;
                if (i == nums1.length - 1 || j == nums2.length - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}