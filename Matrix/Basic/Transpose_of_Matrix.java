/*
Write a program to find the transpose of a square matrix of size N*N. 
Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Example 1:

Input:
N = 4
mat[][] = {{1, 1, 1, 1},
           {2, 2, 2, 2}
           {3, 3, 3, 3}
           {4, 4, 4, 4}}
Output: 
{{1, 2, 3, 4},  
 {1, 2, 3, 4}  
 {1, 2, 3, 4}
 {1, 2, 3, 4}} 
Example 2:

Input:
N = 2
mat[][] = {{1, 2},
           {-9, -2}}
Output:
{{1, -9}, 
 {2, -2}}

Your Task:
You dont need to read input or print anything.
 Complete the function transpose() which takes
  matrix[][] and N as input parameter and finds
   the transpose of the input matrix. You need to
    do this in-place. That is you need to update the
     original matrix with the transpose. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
-103 <= mat[i][j] <= 103

Company Tags
Topic Tags
 */
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class Transpose_of_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int a[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(st[k++]);

            Solution2 ob = new Solution2();
            ob.transpose(a, n);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");

            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution2 {
    // Function to find transpose of a matrix.
    static void transpose(int a[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }

    }
}
