
/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith
 * day.
 * 3. You are required to print the maximum profit you can make if you are
 * allowed infinite transactions, but have to cooldown for 1 day after 1
 * transaction
 * i.e. you cannot buy on the next day after you sell, you have to cooldown for
 * a day at-least before buying again.
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
 * A number representing the maximum profit you can make if you are allowed
 * infinite transactions with cooldown of 1 day.
 * 
 * Example
 * Sample Input
 * 
 * 12
 * 10
 * 15
 * 17
 * 20
 * 16
 * 18
 * 22
 * 20
 * 22
 * 20
 * 23
 * 25
 * 
 * Sample Output
 * 19
 */

import java.util.*;

public class Buy_And_Sell_Stocks_With_Cooldown_Infinite_Transaction_Allowed {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int sold = 0, buy = -a[0], cooldown = 0;
        for (int i = 1; i < n; i++) {
            int newBuy = cooldown - a[i];
            int newSold = buy + a[i];
            if (i > 1) {
                cooldown = Math.max(cooldown, sold);
            }
            sold = Math.max(sold, newSold);
            buy = Math.max(buy, newBuy);
        }
        System.out.println(sold);
        scan.close();
    }

}