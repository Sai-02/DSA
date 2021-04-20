
/*

 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Rotate_by_90_degree {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution5 ob = new Solution5();
            ob.rotateby90(matrix, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution5 {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int a[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
        int i = 0;
        int j = n - 1;
        while (j > i) {
            for (int k = 0; k < n; k++) {
                int temp = a[i][k];
                a[i][k] = a[j][k];
                a[j][k] = temp;
            }

            j--;
            i++;
        }

    }
}
