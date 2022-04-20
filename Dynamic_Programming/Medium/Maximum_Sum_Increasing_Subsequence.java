
/**
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the sum of elements of the increasing
 * subsequence with maximum sum for the array.
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= n1, n2, .. <= 100
 * 
 * Format
 * Input
 * A number n
 * .. n more elements
 * 
 * Output
 * A number representing the sum of elements of the increasing subsequence with
 * maximum sum for the array.
 * 
 * Example
 * Sample Input
 * 
 * 10
 * 10
 * 22
 * 9
 * 33
 * 21
 * 50
 * 41
 * 60
 * 80
 * 1
 * 
 * Sample Output
 * 255
 */
import java.util.*;

public class Maximum_Sum_Increasing_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        int dp[] = new int[n];
        int ans = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] >= a[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = a[i] + max;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

}