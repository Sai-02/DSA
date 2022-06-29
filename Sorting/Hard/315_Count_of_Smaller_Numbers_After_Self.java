
/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 * 
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 * 
 * Input: nums = [-1,-1]
 * Output: [0,0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * Accepted
 * 231,594
 * Submissions
 * 551,032
 */

import java.util.*;

class Solution {
    class Pair {
        int index, val;

        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Pair pairs[] = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
            ans.add(0);
        }
        mergeSort(pairs, ans);
        return ans;
    }

    public Pair[] mergeSort(Pair[] pairs, List<Integer> ans) {
        if (pairs.length == 1)
            return pairs;
        int start = 0, end = pairs.length;
        int mid = (start + end) / 2;
        Pair lp[] = mergeSort(Arrays.copyOfRange(pairs, 0, mid), ans);
        Pair rp[] = mergeSort(Arrays.copyOfRange(pairs, mid, end), ans);
        Pair merge[] = new Pair[lp.length + rp.length];
        int i = 0, j = 0, index = 0, count = 0;
        while (i < lp.length && j < rp.length) {
            if (lp[i].val > rp[j].val) {
                count++;
                merge[index++] = rp[j++];
            } else {
                ans.set(lp[i].index, ans.get(lp[i].index) + count);
                merge[index++] = lp[i++];
            }
        }
        while (i < lp.length) {
            ans.set(lp[i].index, ans.get(lp[i].index) + count);
            merge[index++] = lp[i++];
        }
        while (j < rp.length) {
            merge[index++] = rp[j++];
        }
        return merge;
    }
}