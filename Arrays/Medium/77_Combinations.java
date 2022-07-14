
/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Example 2:
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * Accepted
 * 554,328
 * Submissions
 * 854,155
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solver(n, k, ans, temp, 1);
        return ans;
    }

    public void solver(int n, int k, List<List<Integer>> ans, List<Integer> temp, int start) {
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (start > n)
            return;
        for (int i = start; i <= n; i++) {
            temp.add(i);
            solver(n, k, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}