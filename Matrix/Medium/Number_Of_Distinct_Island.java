
/**
 * Given an m*n binary matrix mat, return the number of distinct island.
 * 
 * An island is considered to be the same as another if and only if one island
 * can be translated (and not rotated or reflected) to equal the other.
 * 
 * Constraints
 * 1<= n <= 1000
 * 1<= e <= n*(n-1)/2
 * 
 * Format
 * Input
 * First line contains two integers n and m.
 * Each of next n lines contain n numbers containing either 0 or 1.
 * 
 * Output
 * print number of distinct island.
 * 
 * Example
 * Sample Input
 * 
 * 3 3
 * 1 0 0
 * 0 1 0
 * 1 1 1
 * 
 * Sample Output
 * 2
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Number_Of_Distinct_Island {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> h = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    psf.append("x");
                    solver(arr, i, j);
                    h.add(psf.toString());
                    psf.setLength(0);
                }
            }
        }
        return h.size();
    }

    public static void solver(int arr[][], int r, int c) {
        arr[r][c] = 0;
        if (r - 1 >= 0 && arr[r - 1][c] == 1) {
            psf.append("u");
            solver(arr, r - 1, c);
        }
        if (c + 1 < arr[0].length && arr[r][c + 1] == 1) {
            psf.append("r");
            solver(arr, r, c + 1);
        }
        if (r + 1 < arr.length && arr[r + 1][c] == 1) {
            psf.append("d");
            solver(arr, r + 1, c);
        }
        if (c - 1 >= 0 && arr[r][c - 1] == 1) {
            psf.append("l");
            solver(arr, r, c - 1);
        }
        psf.append("z");
    }
}
