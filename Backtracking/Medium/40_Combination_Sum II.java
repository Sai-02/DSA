
/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * Accepted
 * 598,627
 * Submissions
 * 1,133,548
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        solver(candidates, 0, target, ans, temp);
        return ans;
    }

    public void solver(int candidates[], int start, int target, List<List<Integer>> ans, LinkedList<Integer> temp) {
        if (target == 0) {
            List<Integer> b = new ArrayList<Integer>(temp);
            ans.add(b);
            return;
        }
        if (start >= candidates.length)
            return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (target - candidates[i] < 0)
                break;
            temp.addLast(candidates[i]);
            solver(candidates, i + 1, target - candidates[i], ans, temp);
            temp.removeLast();
        }

    }
}