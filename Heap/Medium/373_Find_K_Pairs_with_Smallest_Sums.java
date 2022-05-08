
/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u, v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * 
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * 
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in ascending order.
 * 1 <= k <= 104
 * Accepted
 * 169,379
 * Submissions
 * 436,925
 */
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        while (pq.size() > 0 && ans.size() < k) {
            Pair pair = pq.remove();
            int i = pair.i, j = pair.j;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            ans.add(list);
            if (j < nums2.length - 1)
                pq.add(new Pair(i, j + 1, nums1[i] + nums2[j + 1]));
        }
        return ans;
    }

}