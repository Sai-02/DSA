
/**
 * Given an integer n, return the number of prime numbers that are strictly less
 * than n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * 
 * Input: n = 0
 * Output: 0
 * Example 3:
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 5 * 106
 */
import java.util.*;

class Solution {
    public int countPrimes(int n) {
        boolean a[] = new boolean[n + 1];
        Arrays.fill(a, true);
        for (int i = 2; (i * i) <= n; i++) {
            if (!a[i])
                continue;
            for (int j = (2 * i); j <= n; j += i) {
                a[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (a[i])
                count++;
        }
        return count;
    }
}