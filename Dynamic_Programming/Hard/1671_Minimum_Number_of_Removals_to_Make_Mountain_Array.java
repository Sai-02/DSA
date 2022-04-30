/**
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array nums​​​, return the minimum number of elements to
 * remove to make nums​​​ a mountain array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,1]
 * Output: 0
 * Explanation: The array itself is a mountain array so we do not need to remove
 * any elements.
 * Example 2:
 * 
 * Input: nums = [2,1,1,5,6,2,3,1]
 * Output: 3
 * Explanation: One solution is to remove the elements at indices 0, 1, and 5,
 * making the array nums = [1,5,6,3,1].
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * It is guaranteed that you can make a mountain array out of nums.
 * Accepted
 * 12,815
 * Submissions
 * 29,721
 */

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int lis[] = new int[nums.length];
        int lds[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max = Math.max(max, lis[j]);
            }
            lis[i] = max + 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j])
                    max = Math.max(max, lds[j]);
            }
            lds[i] = max + 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1)
                min = Math.min(min, nums.length - (lis[i] + lds[i] - 1));
        }
        return min;
    }
}