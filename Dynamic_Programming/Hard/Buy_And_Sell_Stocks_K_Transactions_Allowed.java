
/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith
 * day.
 * 3. You are given a number k, representing the number of transactions allowed.
 * 3. You are required to print the maximum profit you can make if you are
 * allowed k transactions at-most.
 * Note - There can be no overlapping transaction. One transaction needs to be
 * closed (a buy followed by a sell) before opening another transaction (another
 * buy).
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= n1, n2, .. <= 10
 * 0 <= k <= n / 2
 * 
 * Format
 * Input
 * A number n
 * .. n more elements
 * A number k
 * 
 * Output
 * A number representing the maximum profit you can make if you are allowed a
 * single transaction.
 * 
 * Example
 * Sample Input
 * 
 * 6
 * 9
 * 6
 * 7
 * 6
 * 3
 * 8
 * 1
 * 
 * 
 * Sample Output
 * 5
 */

import java.util.*;

public class Buy_And_Sell_Stocks_K_Transactions_Allowed {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int dp[][] = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, dp[i - 1][j - 1] - a[j - 1]);
                dp[i][j] = Math.max(maxProfit + a[j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[k][n - 1]);
        scan.close();
    }

}