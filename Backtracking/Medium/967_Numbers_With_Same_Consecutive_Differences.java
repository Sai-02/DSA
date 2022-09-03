
/**
 * Return all non-negative integers of length n such that the absolute
 * difference between every two consecutive digits is k.
 * 
 * Note that every number in the answer must not have leading zeros. For
 * example, 01 has one leading zero and is invalid.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading
 * zeroes.
 * Example 2:
 * 
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 9
 * 0 <= k <= 9
 * Accepted
 * 75,966
 * Submissions
 * 144,148
 */

import java.util.*;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solver(i, i, n - 1, k, ans);
        }
        Collections.sort(ans);
        int a[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    public void solver(int digit, int val, int n, int k, List<Integer> ans) {
        if (n <= 0)
            return;
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                if (Math.abs(digit - i) == k) {
                    ans.add(val * 10 + i);
                }
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(digit - i) == k) {
                solver(i, val * 10 + i, n - 1, k, ans);
            }
        }

    }
}