
/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * Example 2:
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * Accepted
 * 624,962
 * Submissions
 * 1,141,403
 */

import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums)
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        List<Integer> temp = new ArrayList<>();
        solver(temp, hm, nums.length, ans);
        return ans;
    }

    public void solver(List<Integer> temp, HashMap<Integer, Integer> hm, int n, List<List<Integer>> ans) {
        if (temp.size() == n) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (freq == 0)
                continue;
            temp.add(key);
            hm.put(key, freq - 1);
            solver(temp, hm, n, ans);
            hm.put(key, freq);
            temp.remove(temp.size() - 1);
        }
    }
}