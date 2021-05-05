/*
A beautiful matrix is a matrix in which the sum of elements in each 
row and column is equal.
Given a square matrix of size NxN. 
Find the minimum number of operation(s) that are required to make 
the matrix beautiful. In one operation you can increment the value
 of any one cell by 1.

Example 1:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 4
Explanation:
Updated matrix:
4 3
3 4
1. Increment value of cell(0, 0) by 3
2. Increment value of cell(0, 1) by 1
Hence total 4 operation are required.
Example 2:

Input:
N = 3
matrix[][] = {{1, 2, 3},
              {4, 2, 3},
              {3, 2, 1}}
Output: 6
Explanation:
Original matrix is as follows:
1 2 3
4 2 3
3 2 1
We need to make increment in such a way 
that each row and column has one time 2, 
one time 3 , one time 4. For that we 
need 6 operations.

Your Task: 
You don't need to read input or print anything. 
Complete the function findMinOpeartion() that
 takes matrix and n as input parameters and 
 returns the minimum number of operations.

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 100
1 <= matrix[i][j] <= 200
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Make_Matrix_Beautiful {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String str[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(str[k++]);
            }
            Solution ob = new Solution();
            System.out.println(ob.findMinOperation(matrix, n));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find minimum number of operations that are required
    // to make the matrix beautiful.
    static int findMinOperation(int a[][], int n) {
        int rowSum[] = new int[n];
        int colSum[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                rowSum[i] += a[i][j];
                colSum[j] += a[i][j];

            }
        }
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }
        int count = 0;
        for (int i = 0, j = 0; i < n && j < n;) {
            int diff = Math.min(maxSum - rowSum[i], maxSum - colSum[j]);
            a[i][j] += diff;
            rowSum[i] += diff;
            colSum[j] += diff;
            count += diff;

            if (rowSum[i] == maxSum) {
                i++;
            }
            if (colSum[j] == maxSum) {
                j++;
            }
        }
        return count;
    }
}
// ==================================
// 
// GFG Editorial
// 
// ==================================

// The approach is simple, let’s assume that maxSum is the maximum sum among 
// all rows and columns. We just need to increment some cells such that the 
// sum of any row or column becomes ‘maxSum’.
// Let’s say Xi is the total number of operations needed to make
//  the sum on row ‘i’ equals to maxSum and Yj is the total number 
//  of operations needed to make the sum on column ‘j’ equals to maxSum. 
//  Since Xi = Yj so we need to work at any one of them according to the condition.

// In order to minimise Xi, we need to choose the maximum from rowSumi and 
// colSumj as it will surely lead to minimum operation. After that, increment
//  ‘i’ or ‘j’ according to the condition satisfied after increment.




// class Solution 
// {
//     //Function to find minimum number of operations that are required 
//     //to make the matrix beautiful.
//     static int findMinOperation(int matrix[][], int n)
//     {
//         int sumRow[] = new int[n];
//         int sumCol[] = new int[n];
//         Arrays.fill(sumRow, 0);
//         Arrays.fill(sumCol, 0);
        
//         //calculating sumRow[] and sumCol[] array.
//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 sumRow[i] += matrix[i][j];
//                 sumCol[j] += matrix[i][j];
                  
//             }
//         }
        
//         //finding maximum sum value in either row or in column.
//         int maxSum = 0;
//         for (int i = 0; i < n; ++i)
//         {
//             maxSum = Math.max(maxSum, sumRow[i]);
//             maxSum = Math.max(maxSum, sumCol[i]);
//         } 
        
//         int count = 0;
//         for (int i = 0, j = 0; i < n && j < n;) 
//         {
//             //finding minimum increment required in either row or column.
//             int diff = Math.min(maxSum - sumRow[i], maxSum - sumCol[j]);
            
//             //adding difference in corresponding cell, 
//             //sumRow[] and sumCol[] array.
//             matrix[i][j] += diff;
//             sumRow[i] += diff;
//             sumCol[j] += diff;
            
//             //updating the result.
//             count += diff;
            
//             //if ith row is satisfied, incrementing i for next iteration.
//             if (sumRow[i] == maxSum)
//                 ++i;
            
//             //if jth column is satisfied, incrementing j for next iteration.
//             if (sumCol[j] == maxSum)
//                 ++j;
//         }
//         //returning the result.
//         return count;
//     }
// }