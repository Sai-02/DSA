
/**
 * 1. You are given a number n and a number k in separate lines, representing
 * the number of fences and number of colors.
 * 2. You are required to calculate and print the number of ways in which the
 * fences could be painted so that not more than two consecutive fences have
 * same colors.
 * 
 * Constraints
 * 1 <= n <= 10
 * 1 <= k <= 10
 * 
 * Format
 * Input
 * A number n
 * A number k
 * 
 * Output
 * A number representing the number of ways in which the fences could be painted
 * so that not more than two fences have same colors.
 * 
 * Example
 * Sample Input
 * 
 * 8
 * 3
 * 
 * Sample Output
 * 3672
 */

import java.util.*;

public class Paint_Fence {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int equal = 0, notEqual = k;
        for (int i = 2; i <= n; i++) {
            int newEqual = notEqual;
            int newNotEqual = (equal + notEqual) * (k - 1);
            equal = newEqual;
            notEqual = newNotEqual;
        }
        System.out.println(equal + notEqual);
        scan.close();
    }
}