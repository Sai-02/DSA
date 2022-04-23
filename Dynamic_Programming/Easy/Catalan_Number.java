
/**
 * 1. You are given a number n.
 * 2. You are required to find the value of nth catalan number.
 * C0 -> 1
 * C1 -> 1
 * C2 -> 2
 * C3 -> 5
 * ..
 * Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0
 * 
 * Constraints
 * 0 <= n <= 15
 * 
 * Format
 * Input
 * A number n
 * 
 * Output
 * A number representing the value of nth catalan number.
 * 
 * Example
 * Sample Input
 * 
 * 4
 * 
 * Sample Output
 * 14
 */

import java.util.*;

public class Catalan_Number {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);
        scan.close();
    }

}