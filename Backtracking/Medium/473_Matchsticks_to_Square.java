
/**
 * You are given an integer array matchsticks where matchsticks[i] is the length
 * of the ith matchstick. You want to use all the matchsticks to make one
 * square. You should not break any stick, but you can link them up, and each
 * matchstick must be used exactly one time.
 * 
 * Return true if you can make this square and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came
 * two sticks with length 1.
 * Example 2:
 * 
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * 
 * Constraints:
 * 
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 * Accepted
 * 81,903
 * Submissions
 * 203,617
 */

import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4)
            return false;
        int sides[] = new int[4];
        int sum = 0;
        for (int val : matchsticks)
            sum += val;
        if (sum % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks, sides, 0, sum / 4);
    }

    public boolean dfs(int matchsticks[], int sides[], int index, int target) {
        if (index == matchsticks.length) {
            if (sides[0] == target && sides[1] == target && sides[3] == target)
                return true;
            else
                return false;
        }
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + matchsticks[index] > target)
                continue;
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index + 1, target))
                return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }

    public void reverse(int nums[]) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}