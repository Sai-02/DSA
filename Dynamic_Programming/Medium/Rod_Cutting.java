
/**
 * 1. You are given an integer N, which represents the length of a rod, and an
 * array of integers, which represents the prices of rod pieces of length
 * varying from 1 to
 * N.
 * 2. You have to find the maximum value that can be obtained by selling the
 * rod.
 * 3. You can sell it in pieces or as a whole.
 * 
 * Constraints
 * 1 <= N <= 100000
 * 1 <= arr[i] <= 10^8
 * 
 * Format
 * Input
 * A number N
 * arr1
 * arr2.. N integers
 * 
 * Output
 * Check the sample output and question video.
 * 
 * Example
 * Sample Input
 * 
 * 8
 * 1
 * 5
 * 8
 * 9
 * 10
 * 17
 * 17
 * 20
 * 
 * Sample Output
 * 22
 */

import java.util.*;

public class Rod_Cutting {

    public static int solution(int[] prices) {
        int np[] = new int[prices.length + 1];
        for (int i = 1; i < np.length; i++)
            np[i] = prices[i - 1];
        int dp[] = new int[np.length];
        dp[1] = np[1];
        for (int i = 2; i < np.length; i++) {
            dp[i] = np[i];
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution(prices));
        scn.close();
    }

}