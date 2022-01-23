
/**
 * 1. You are given a number n and a number k separated by a space, representing
 * the number of houses and number of colors.
 * 2. In the next n rows, you are given k space separated numbers representing
 * the cost of painting nth house with one of the k colors.
 * 3. You are required to calculate and print the minimum cost of painting all
 * houses without painting any consecutive house with same color.
 * 
 * Constraints
 * 1 <= n <= 1000
 * 1 <= k <= 10
 * 0 <= n1-0th, n1-1st, .. <= 1000
 * 
 * Format
 * Input
 * A number n
 * n1-0th n1-1st n1-2nd .. n1-kth
 * n2-0th n2-1st n2-2nd .. n2-kth
 * .. n number of elements
 * 
 * Output
 * A number representing the minimum cost of painting all houses without
 * painting any consecutive house with same color.
 * 
 * Example
 * Sample Input
 * 
 * 4 3
 * 1 5 7
 * 5 8 4
 * 3 2 9
 * 1 2 4
 * 
 * Sample Output
 * 8
 */
import java.util.*;

public class Paint_House_Many_Colors {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int a[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int least = Integer.MAX_VALUE, sleast = Integer.MAX_VALUE;
        int dp[][] = new int[n][k];
        for (int j = 0; j < k; j++) {
            dp[0][j] = a[0][j];
            if (least >= a[0][j]) {
                sleast = least;
                least = a[0][j];
            } else if (sleast >= a[0][j])
                sleast = a[0][j];
        }
        for (int i = 1; i < n; i++) {
            int nleast = Integer.MAX_VALUE, nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                if (least != dp[i - 1][j])
                    min = least;
                else
                    min = sleast;
                dp[i][j] = min + a[i][j];
                if (nleast >= dp[i][j]) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (nsleast >= dp[i][j])
                    nsleast = dp[i][j];
            }
            sleast = nsleast;
            least = nleast;
        }

        System.out.println(least);
        scan.close();

    }
}