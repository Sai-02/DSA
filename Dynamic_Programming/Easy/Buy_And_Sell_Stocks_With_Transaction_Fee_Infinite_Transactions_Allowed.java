
/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith
 * day.
 * 3. You are give a number fee, representing the transaction fee for every
 * transaction.
 * 4. You are required to print the maximum profit you can make if you are
 * allowed infinite transactions, but has to pay "fee" for every closed
 * transaction.
 * Note - There can be no overlapping transaction. One transaction needs to be
 * closed (a buy followed by a sell) before opening another transaction (another
 * buy).
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= n1, n2, .. <= 10
 * 0 <= fee <= 5
 * 
 * Format
 * Input
 * A number n
 * .. n more elements
 * A number fee
 * 
 * Output
 * A number representing the maximum profit you can make if you are allowed
 * infinite transactions with transaction fee.
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
 * 3
 * 
 * Sample Output
 * 13
 * 
 */
import java.util.*;

public class Buy_And_Sell_Stocks_With_Transaction_Fee_Infinite_Transactions_Allowed {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int fee = scan.nextInt();
        int buy = -a[0], sold = 0;
        for (int i = 1; i < n; i++) {
            int newSold = buy + a[i] - fee;
            int newBuy = sold - a[i];
            sold = Math.max(sold, newSold);
            buy = Math.max(buy, newBuy);
        }
        System.out.println(sold);
        scan.close();
    }

}
