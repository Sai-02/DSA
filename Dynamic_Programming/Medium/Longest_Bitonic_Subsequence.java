
/**
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the length of longest bitonic subsequence of
 * array.
 * Note -> bitonic subsequence begins with elements in increasing order,
 * followed by elements in decreasing order.
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
 * A number representing the length of longest increasing subsequence of array.
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
 * 7
 */

import java.util.*;

public class Longest_Bitonic_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scan.nextInt();
        int lis[] = new int[n];
        int lds[] = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(lis[j], max);
                }
            }
            lis[i] = max + 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, lds[j]);
                }
            }
            lds[i] = max + 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }
        System.out.println(ans);

    }

}
