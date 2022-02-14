
/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith
 * day.
 * 3. You are required to print the maximum profit you can make if you are
 * allowed two transactions at-most.
 * Note - There can be no overlapping transaction. One transaction needs to be
 * closed (a buy followed by a sell) before opening another transaction (another
 * buy).
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= n1, n2, .. <= 10
 * 
 * Format
 * Input
 * A number n
 * .. n more elements
 * 
 * Output
 * A number representing the maximum profit you can make if you are allowed a
 * single transaction.
 * 
 * Example
 * Sample Input
 * 
 * 9
 * 11
 * 6
 * 7
 * 19
 * 4
 * 1
 * 6
 * 18
 * 4
 * 
 * Sample Output
 * 30
 */

import java.util.*;

public class Buy_And_Sell_Stocks_Two_Transactions_Allowed {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int maxProfitSold[] = new int[n];
        int minBuy = a[0];
        for (int i = 1; i < n; i++) {
            maxProfitSold[i] = Math.max(maxProfitSold[i - 1], a[i] - minBuy);
            minBuy = Math.min(minBuy, a[i]);
        }
        int maxProfitBuy[] = new int[n];
        int maxSold = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxProfitBuy[i] = Math.max(maxProfitBuy[i + 1], maxSold - a[i]);
            maxSold = Math.max(maxSold, a[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, maxProfitBuy[i] + maxProfitSold[i]);
        }
        System.out.println(maxProfit);
        scan.close();
    }

}