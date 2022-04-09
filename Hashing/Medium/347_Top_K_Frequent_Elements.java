/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 */

// ====================================================
// 
// Brute Force
// 
// ====================================================

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Pair> list = new ArrayList<>();
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        for (int val : nums) {
            if (hm.containsKey(val)) {
                list.add(new Pair(val, hm.get(val)));
                hm.remove(val);
            }
        }
        Collections.sort(list, (p1, p2) -> p2.freq - p1.freq);
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).val;
        }
        return ans;
    }
}

class Pair {
    int val, freq;

    Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

// ==========================================================
//
// Priority Queue
//
// ==========================================================

class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int val : hm.keySet()) {
            pq.add(new Pair(val, hm.get(val)));
            if (pq.size() > k)
                pq.remove();
        }
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().val;
        }
        return ans;
    }
}

// ==================================================================
//
// Bucket Sort (TC - O(n) and SC - O(n) )
//
// ===================================================================

class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[k];
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        ArrayList<Integer> bucket[] = new ArrayList[nums.length + 1];
        for (int val : hm.keySet()) {
            int freq = hm.get(val);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(val);
        }
        int index = bucket.length - 1, i = 0;
        while (i < k) {
            if (bucket[index] != null) {
                for (int val : bucket[index]) {
                    if (i == k)
                        break;
                    ans[i++] = val;
                }
            }
            index--;
        }
        return ans;

    }
}