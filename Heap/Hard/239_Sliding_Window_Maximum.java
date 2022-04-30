
/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 3 -1] -3 5 3 6 7 3
 * 1 [3 -1 -3] 5 3 6 7 3
 * 1 3 [-1 -3 5] 3 6 7 5
 * 1 3 -1 [-3 5 3] 6 7 5
 * 1 3 -1 -3 [5 3 6] 7 6
 * 1 3 -1 -3 5 [3 6 7] 7
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * Accepted
 * 561,172
 * Submissions
 * 1,214,250
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */
import java.util.*;

// ====================================================
// 
// Brute Force O(nlogn)
// 
// ====================================================
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        while (index < nums.length) {
            if (pq.size() < k)
                pq.add(new Pair(nums[index], index));
            else {
                while (pq.peek().index < index - k)
                    pq.remove();
                ans.add(pq.peek().val);
                pq.add(new Pair(nums[index], index));
            }
            index++;
        }
        while (pq.peek().index < index - k)
            pq.remove();
        ans.add(pq.peek().val);
        int a[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    class Pair implements Comparable<Pair> {
        int val, index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int compareTo(Pair o) {
            return o.val - this.val;
        }
    }
}

// =========================================
//
// Optimized O(n) Solution using Stack
//
// =========================================

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (st.empty())
                st.push(i);
            else {
                while (!st.empty() && nums[st.peek()] < nums[i])
                    nge[st.pop()] = i;
                st.push(i);
            }
        }
        while (!st.empty())
            nge[st.pop()] = nums.length;
        ArrayList<Integer> a = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (j < i)
                j = i;
            while (nge[j] < i + k)
                j = nge[j];
            a.add(nums[j]);
        }
        int ans[] = new int[a.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = a.get(i);
        return ans;
    }
}