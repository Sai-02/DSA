
/**
 * Input
 * A number n
 * A number m
 * e11
 * e12..
 * e21
 * e22..
 * .. n * m number of elements
 * 
 * Output
 * Check the sample output and question video.
 * 
 * Example
 * Sample Input
 * 
 * 6
 * 6
 * 0 1 4 2 8 2
 * 4 3 6 5 0 4
 * 1 2 4 1 4 6
 * 2 0 7 3 2 2
 * 3 1 5 9 2 4
 * 2 7 0 8 5 1
 * 
 * Sample Output
 * 33
 * 4 d3 d1 d2 d3 d1
 */
import java.io.*;
import java.util.*;

public class Print_All_Paths_With_Maximum_Gold {

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int dp[][] = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (j == m - 1)
                    dp[i][j] = arr[i][j];
                else {
                    int max = dp[i][j + 1];
                    if (i - 1 >= 0)
                        max = Math.max(max, dp[i - 1][j + 1]);
                    if (i + 1 < n)
                        max = Math.max(max, dp[i + 1][j + 1]);
                    dp[i][j] = arr[i][j] + max;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(dp[i][0], max);
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == max)
                q.add(new Pair(i + "", i, 0));
        }
        System.out.println(max);
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            if (pair.j == m - 1)
                System.out.println(pair.psf);
            else {
                int i = pair.i, j = pair.j;
                int maxVal = dp[i][j + 1];
                if (i - 1 >= 0)
                    maxVal = Math.max(maxVal, dp[i - 1][j + 1]);
                if (i + 1 < n)
                    maxVal = Math.max(maxVal, dp[i + 1][j + 1]);
                if (i - 1 >= 0 && maxVal == dp[i - 1][j + 1])
                    q.add(new Pair(pair.psf + " d1", i - 1, j + 1));
                if (dp[i][j + 1] == maxVal)
                    q.add(new Pair(pair.psf + " d2", i, j + 1));
                if (i + 1 < n && maxVal == dp[i + 1][j + 1])
                    q.add(new Pair(pair.psf + " d3", i + 1, j + 1));
            }
        }

    }

}