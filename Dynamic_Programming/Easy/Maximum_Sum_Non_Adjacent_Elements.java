
/**
 * Easy
 * 
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers, representing n elements.
 * 3. You are required to find the maximum sum of a subsequence with no adjacent
 * elements.
 * 
 * Constraints
 * 1 <= n <= 1000
 * -1000 <= n1, n2, .. n elements <= 1000
 * 
 * Format
 * Input
 * A number n
 * n1
 * n2
 * .. n number of elements
 * 
 * Output
 * A number representing the maximum sum of a subsequence with no adjacent
 * elements.
 * 
 * Example
 * Sample Input
 * 
 * 6
 * 5
 * 10
 * 10
 * 100
 * 5
 * 6
 * 
 * Sample Output
 * 116
 */

import java.util.*;

public class Maximum_Sum_Non_Adjacent_Elements {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int dp[] = new int[n + 1];
        dp[1] = a[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], a[i - 1] + dp[i - 2]);
        }
        System.out.println(dp[n]);
        scan.close();
    }
}