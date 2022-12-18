/**
 * You are given a positive integer n.
 * 
 * Continuously replace n with the sum of its prime factors.
 * 
 * Note that if a prime factor divides n multiple times, it should be included
 * in the sum as many times as it divides n.
 * Return the smallest value n will take on.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 15
 * Output: 5
 * Explanation: Initially, n = 15.
 * 15 = 3 * 5, so replace n with 3 + 5 = 8.
 * 8 = 2 * 2 * 2, so replace n with 2 + 2 + 2 = 6.
 * 6 = 2 * 3, so replace n with 2 + 3 = 5.
 * 5 is the smallest value n will take on.
 * Example 2:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, n = 3.
 * 3 is the smallest value n will take on.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 105
 * Accepted
 * 9,326
 * Submissions
 * 20,700
 */

class Solution {
    public int smallestValue(int n) {
        int ans = solver(n);
        if (ans == n)
            return n;
        return smallestValue(ans);
    }

    public int solver(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n = n / i;
            }
        }
        return ans;
    }
}