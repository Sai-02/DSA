
/**
 * Given an array of n distinct elements. Find the minimum number of swaps
 * required to sort the array in strictly increasing order.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * nums = {2, 8, 5, 4}
 * Output:
 * 1
 * Explaination:
 * swap 8 with 4.
 * Example 2:
 * 
 * Input:
 * nums = {10, 19, 6, 3, 5}
 * Output:
 * 2
 * Explaination:
 * swap 10 with 3 and swap 19 with 5.
 * 
 * Your Task:
 * You do not need to read input or print anything. Your task is to complete the
 * function minSwaps() which takes the nums as input parameter and returns an
 * integer denoting the minimum number of swaps required to sort the array. If
 * the array is already sorted, return 0.
 * 
 * 
 * Expected Time Complexity: O(nlogn)
 * Expected Auxiliary Space: O(n)
 * 
 * 
 * Constraints:
 * 1 ≤ n ≤ 105
 * 1 ≤ numsi ≤ 106
 */
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int val, index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int ans = 0;
        boolean visited[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || pairs[i].index == i)
                continue;
            int length = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                length++;
                j = pairs[j].index;
            }
            ans += length - 1;
        }
        return ans;
    }
}