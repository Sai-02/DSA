
/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3,
 * and 5.
 * 
 * Given an integer n, return the nth ugly number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
 * ugly numbers.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * limited to 2, 3, and 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1690
 * Accepted
 * 257,453
 * Submissions
 * 568,719
 */
import java.util.*;

// ============================================
//
// Solution using PriorityQueue
//
// ===============================================
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        HashSet<Long> h = new HashSet<>();
        while (n-- > 0) {
            long val = pq.remove();
            if (n == 0)
                return (int) val;
            if (!h.contains(val * 2)) {
                pq.add(val * 2);
                h.add(val * 2);
            }
            if (!h.contains(val * 3)) {
                pq.add(val * 3);
                h.add(val * 3);
            }
            if (!h.contains(val * 5)) {
                pq.add(val * 5);
                h.add(val * 5);
            }
        }
        return -1;
    }
}

// ========================================
//
// DP Solution
//
// =========================================

class Solution2 {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int i = 1, j = 1, k = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = Math.min(2 * dp[i], Math.min(3 * dp[j], 5 * dp[k]));
            if (dp[index] == 2 * dp[i])
                i++;
            if (dp[index] == 3 * dp[j])
                j++;
            if (dp[index] == 5 * dp[k])
                k++;
        }
        return dp[n];
    }
}