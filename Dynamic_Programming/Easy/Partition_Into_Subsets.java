
/**
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given a number k, representing the number of subsets.
 * 3. You are required to print the number of ways in which these elements can
 * be partitioned in k non-empty subsets.
 * E.g.
 * For n = 4 and k = 3 total ways is 6
 * 12-3-4
 * 1-23-4
 * 13-2-4
 * 14-2-3
 * 1-24-3
 * 1-2-34
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= k <= n
 * 
 * Format
 * Input
 * A number n
 * A number k
 * 
 * Output
 * A number representing the number of ways in which these elements can be
 * partitioned in k non-empty subsets.
 * 
 * Example
 * Sample Input
 * 
 * 4
 * 3
 * 
 * Sample Output
 * 6
 */

import java.util.*;

public class Partition_Into_Subsets {

    public static long partitionKSubset(int n, int k) {
        long dp[][] = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i)
                    dp[i][j] = 0;
                else if (i == j)
                    dp[i][j] = 1;
                else {
                    dp[i][j] += dp[i - 1][j - 1] + i * dp[i][j - 1];
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long res = partitionKSubset(n, k);
        System.out.println(res);
        scn.close();
    }
}