
/**
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers.
 * 3. You are given a number "tar".
 * 4. You are required to calculate and print true or false, if there is a
 * subset the elements of which add up to "tar" or not.
 * 5. Also, you have to print the indices of elements that should be selected to
 * achieve the given target.
 * 6. You have to print all such configurations.
 * 
 * Constraints
 * 1 <= n <= 30
 * 0 <= n1, n2, .. n elements <= 20
 * 0 <= tar <= 50
 * 
 * Format
 * Input
 * A number n
 * n1
 * n2
 * .. n number of elements
 * A number tar
 * 
 * Output
 * Check the sample output and question video.
 * 
 * Example
 * Sample Input
 * 
 * 5
 * 4
 * 2
 * 7
 * 1
 * 3
 * 10
 * 
 * Sample Output
 * true
 * 2 4
 * 1 2 3
 * 0 1 3 4
 */

import java.io.*;
import java.util.*;

public class Print_All_Paths_With_Target_Sum_Subset {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean dp[][] = new boolean[n + 1][tar + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        System.out.println(dp[n][tar]);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, tar, ""));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (rem.j == 0 || rem.i == 0)
                System.out.println(rem.psf);
            else {
                if (rem.j >= arr[rem.i - 1] && dp[rem.i - 1][rem.j - arr[rem.i - 1]]) {
                    q.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], (rem.i - 1) + " " + rem.psf));
                }
                if (dp[rem.i - 1][rem.j])
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
            }
        }
    }
}
