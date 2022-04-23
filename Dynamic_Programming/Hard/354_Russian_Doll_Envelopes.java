
/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
 * represents the width and the height of an envelope.
 * 
 * One envelope can fit into another if and only if both the width and height of
 * one envelope are greater than the other envelope's width and height.
 * 
 * Return the maximum number of envelopes you can Russian doll (i.e., put one
 * inside the other).
 * 
 * Note: You cannot rotate an envelope.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3]
 * => [5,4] => [6,7]).
 * Example 2:
 * 
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 * Accepted
 * 135,099
 * Submissions
 * 346,724
 */

import java.util.*;

// ================================================================================
// 
// DP Solution : TC-O(n2)
// 
// ==================================================================================

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        int maxCount = 0;
        int dp[] = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }
}

// ======================================================================
//
// Solution Using Binary Search TC-O(nlogn)
//
// =======================================================================

class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a2[1] - a1[1];
            return a1[0] - a2[0];
        });
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            if (a.size() == 0 || envelopes[i][1] > a.get(a.size() - 1)) {
                a.add(envelopes[i][1]);
            } else {
                int l = 0, r = a.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (a.get(mid) == envelopes[i][1]) {
                        l = mid;
                        break;
                    } else if (a.get(mid) > envelopes[i][1]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                a.set(l, envelopes[i][1]);
            }
        }
        return a.size();
    }
}
