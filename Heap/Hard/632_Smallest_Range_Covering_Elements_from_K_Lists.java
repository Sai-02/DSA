
/**
 * You have k lists of sorted integers in non-decreasing order. Find the
 * smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a
 * < c if b - a == d - c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Example 2:
 * 
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] is sorted in non-decreasing order.
 * Accepted
 * 65,419
 * Submissions
 * 111,589
 */
import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int li = 0; li < nums.size(); li++) {
            pq.add(new Pair(nums.get(li).get(0), li, 0));
            max = Math.max(nums.get(li).get(0), max);
        }
        int l = 0, r = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            Pair pair = pq.remove();
            if (r - l > max - pair.val) {
                l = pair.val;
                r = max;
            }
            if (pair.i < nums.get(pair.li).size() - 1) {
                pq.add(new Pair(nums.get(pair.li).get(pair.i + 1), pair.li, pair.i + 1));
                max = Math.max(max, nums.get(pair.li).get(pair.i + 1));
            }
        }
        int ans[] = new int[2];
        ans[0] = l;
        ans[1] = r;
        return ans;
    }

    class Pair implements Comparable<Pair> {
        int val, li, i;

        Pair(int val, int li, int i) {
            this.val = val;
            this.li = li;
            this.i = i;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}