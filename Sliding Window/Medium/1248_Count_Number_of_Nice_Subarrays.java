/**
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
 * [1,2,1,1].
 * Example 2:
 * 
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 * 
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
        }
        int l = 0, r = k - 1, count = 0;
        while (r < list.size()) {
            int a = l == 0 ? list.get(l) : list.get(l) - list.get(l - 1) - 1;
            int b = r == list.size() - 1 ? nums.length - 1 - list.get(r) : list.get(r + 1) - list.get(r) - 1;
            count += (a + 1) * (b + 1);
            l++;
            r++;
        }
        return count;

    }
}