
/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith
 * day.
 * 3. You are required to print the maximum profit you can make if you are
 * allowed infinite transactions.
 * Note - There can be no overlapping transaction. One transaction needs to be
 * closed (a buy followed by a sell) before opening another transaction (another
 * buy)
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
 * infinite transactions.
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

public class Buy_And_Sell_Stocks_Infinite_Transactions_Allowed {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        int bd = 0, sd = 0, profit = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[i - 1])
                sd++;
            else {
                profit += a[sd] - a[bd];
                bd = sd = i;
            }
        }
        profit += a[sd] - a[bd];
        System.out.println(profit);
        scan.close();
    }
}