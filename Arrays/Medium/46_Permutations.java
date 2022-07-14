
/**
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * 
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * 
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * Accepted
 * 1,248,731
 * Submissions
 * 1,702,827
 */

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        solver(nums, ans, temp, h);
        return ans;
    }

    public void solver(int nums[], List<List<Integer>> ans, List<Integer> temp, HashSet<Integer> h) {
        if (h.size() == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!h.contains(i)) {
                temp.add(nums[i]);
                h.add(i);
                solver(nums, ans, temp, h);
                temp.remove(temp.size() - 1);
                h.remove(i);
            }
        }
    }
}