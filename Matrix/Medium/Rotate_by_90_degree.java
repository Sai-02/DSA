/*
Given a square matrix[][] of size N x N. 
The task is to rotate it by 90 degrees in an anti-clockwise
 direction without using any extra space.

Example 1:

Input:
N = 3
matrix[][] = [[1 2 3],
              [4 5 6],
              [7 8 9]]
Output:
3 6 9 
2 5 8 
1 4 7
Your Task:
You only need to implement the given function rotate().
 Do not read input, instead use the arguments given in the function. 

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 50
1 <= matrix[][] <= 100

 

Company Tags
 */

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Rotate_by_90_degree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}// } Driver Code Ends

// User function Template for Java

class GFG {
    static void rotate(int a[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
        int i = 0, k = n - 1;
        while (i < k) {
            for (int j = 0; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[k][j];
                a[k][j] = temp;
            }

            i++;
            k--;
        }

    }
}

// ==============================
// 
// GFG Editorial
// 
// ==============================


// A N x N matrix will have floor(N/2) square cycles.
//  For example, a 4 X 4 matrix will have 2 cycles.
//   The first cycle is formed by its 1st row, last column, 
//   last row and 1st column. The second cycle is formed by 2nd row, 
//   second-last column, second-last row and 2nd column.

// The idea is for each square cycle, we swap the elements involved with 
// the corresponding cell in the matrix in anti-clockwise direction 
// i.e. from top to left, left to bottom,
//  bottom to right and from right to top one at a time. 
//  We use nothing but a temporary variable to achieve this.


// class GFG { 
//     static void rotate(int matrix[][]) 
// 	{ 
// 		int n = matrix.length;
// 	    for (int i = 0; i < n/2; ++i)
// 	    {
// 	        for(int j=i; j<n-i-1; j++)
// 	        {
// 	            // swap in anti-clockwise direction
// 	            int temp = matrix[i][j];
// 	            matrix[i][j] = matrix[j][n-1-i];        // right to top
// 	            matrix[j][n-1-i] = matrix[n-1-i][n-1-j];// bottom to right
// 	            matrix[n-1-i][n-1-j] = matrix[n-1-j][i];// left to bottom
// 	            matrix[n-1-j][i] = temp;                // top to left
// 	        }
// 	    }
// 	} 
// } 
