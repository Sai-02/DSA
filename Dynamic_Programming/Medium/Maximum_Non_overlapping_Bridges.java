
/**
 * 1. You are given a number n, representing the number of bridges on a river.
 * 2. You are given n pair of numbers, representing the north bank and south
 * bank co-ordinates of each bridge.
 * 3. You are required to print the count of maximum number of non-overlapping
 * bridges.
 * 
 * Constraints
 * 0 <= n <= 20
 * 0 <= n1n, n1s, n2n, n2s, .. <= 100
 * 
 * Format
 * Input
 * A number n
 * .. n pair of number each on a separate line (and pair separated by space)
 * 
 * Output
 * A number representing the count of maximum number of non-overlapping bridges.
 * 
 * Example
 * Sample Input
 * 
 * 10
 * 10 20
 * 2 7
 * 8 15
 * 17 3
 * 21 40
 * 50 4
 * 41 57
 * 60 80
 * 80 90
 * 1 30
 * 
 * Sample Output
 * 7
 */
import java.util.*;

public class Maximum_Non_overlapping_Bridges {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        Arrays.sort(a, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        int dp[] = new int[n];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i][1] > a[j][1])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            maxCount = Math.max(maxCount, dp[i]);
        }
        System.out.println(maxCount);
    }

}