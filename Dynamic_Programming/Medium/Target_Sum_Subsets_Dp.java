
/**
 * 1. You are given a number n, representing the count of elements. 2. You are
 * given n numbers. 3. You are given a number "tar". 4. You are required to
 * calculate and print true or false, if there is a subset the elements of which
 * add up to "tar" or not. Input Format A number n n1 n2 .. n number of elements
 * A number tar Output Format true or false as required Question Video
 * 
 * COMMENTConstraints 1 <= n <= 30 0 <= n1, n2, .. n elements <= 20 0 <= tar <=
 * 50 Sample Input 5 4 2 7 1 3 10 Sample Output true
 */

import java.util.*;

public class Target_Sum_Subsets_Dp {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int tar = scan.nextInt();
        boolean dp[][] = new boolean[n + 1][tar + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < tar + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j < a[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }
        boolean found = false;

        for (int i = 1; i < n + 1; i++) {
            if (dp[i][tar]) {
                found = true;
            }
        }
        System.out.println(found);

        scan.close();

    }
}

// ============================================================================================
// 
//  Explanation: https://www.youtube.com/watch?v=tRpkluGqINc&t=1343s&ab_channel=Pepcoding
// 
// ============================================================================================