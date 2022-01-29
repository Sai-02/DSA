
/**
 * 1. You are given a number n, representing the number of friends.
 * 2. Each friend can stay single or pair up with any of it's friends.
 * 3. You are required to print the number of ways in which these friends can
 * stay single or pair up.
 * E.g.
 * 1 person can stay single or pair up in 1 way.
 * 2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
 * 3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3,
 * 13-2, 23-1.
 * 
 * Constraints
 * 0 <= n <= 20
 * 
 * Format
 * Input
 * A number n
 * 
 * Output
 * A number representing the number of ways in which n friends can stay single
 * or pair up.
 * 
 * Example
 * Sample Input
 * 
 * 4
 * 
 * Sample Output
 * 10
 */

import java.util.*;

public class Friends_Pairing {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        System.out.println(dp[n]);
        scan.close();
    }
}