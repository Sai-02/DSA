
/**
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
Accepted
140,451
Submissions
234,775
Seen this question in a real interview before?

Yes

No

 */

import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> h = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        solver(h, list, 0, nums);
        return new ArrayList<>(h);
    }

    public void solver(HashSet<List<Integer>> h, List<Integer> list, int index, int[] nums) {
        if (index == nums.length) {
            if (index == nums.length && list.size() > 1)
                h.add(new ArrayList<Integer>(list));
            return;
        }
        if (list.size() == 0 || nums[index] >= list.get(list.size() - 1)) {
            list.add(nums[index]);
            solver(h, list, index + 1, nums);
            list.remove(list.size() - 1);
            solver(h, list, index + 1, nums);
        } else {
            solver(h, list, index + 1, nums);
        }
    }
}