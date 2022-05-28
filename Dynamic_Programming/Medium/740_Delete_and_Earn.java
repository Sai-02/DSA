
/**
 * You are given an integer array nums. You want to maximize the number of
 * points you get by performing the following operation any number of times:
 * 
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must
 * delete every element equal to nums[i] - 1 and every element equal to nums[i]
 * + 1.
 * Return the maximum number of points you can earn by applying the above
 * operation some number of times.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: You can perform the following operations:
 * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
 * - Delete 2 to earn 2 points. nums = [].
 * You earn a total of 6 points.
 * Example 2:
 * 
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: You can perform the following operations:
 * - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums =
 * [3,3].
 * - Delete a 3 again to earn 3 points. nums = [3].
 * - Delete a 3 once more to earn 3 points. nums = [].
 * You earn a total of 9 points.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * Accepted
 * 190,720
 * Submissions
 * 332,300
 */
import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums)
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        ArrayList<Integer> a = new ArrayList<>();
        for (int key : hm.keySet()) {
            a.add(key);
        }
        Collections.sort(a);
        int inc = 0, exc = 0;
        for (int val : a) {
            int newExc = Math.max(inc, exc);
            int newInc;
            if (hm.containsKey(val - 1))
                newInc = exc + (val * hm.get(val));
            else {
                newInc = Math.max(inc, exc) + (val * hm.get(val));
            }
            inc = newInc;
            exc = newExc;
        }
        return Math.max(inc, exc);
    }
}