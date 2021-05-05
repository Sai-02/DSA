/*
Given a boolean matrix of size RxC where each cell contains either 0 or 1,
 modify it such that if a matrix cell matrix[i][j] is 1 then all the cells
  in its ith row and jth column will become 1.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {0, 0}}
Output: 
1 1
1 0 
Explanation:
Only cell that has 1 is at (0,0) so all 
cells in row 0 are modified to 1 and all 
cells in column 0 are modified to 1.

Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output: 
1 1 1
1 1 1
1 1 1
1 0 0 
Explanation:
The position of cells that have 1 in
the original matrix are (0,0), (1,0)
and (2,0). Therefore, all cells in row
0,1,2 are and column 0 are modified to 1. 

Your Task:
You dont need to read input or print anything.
 Complete the function booleanMatrix() that takes
  the matrix as input parameter and modifies it in-place.
 

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R + C) 
 

Constraints:
1 ≤ R, C ≤ 1000
0 ≤ matrix[i][j] ≤ 1
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Boolean_Matrix {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = Integer.parseInt(str[k]);
                    k++;
                }
            }
            new Solution2().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution2 {
    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int a[][]) {
        int n = a.length;
        int m = a[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = 1;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (col[j] == 1) {
                for (int i = 0; i < n; i++) {
                    a[i][j] = 1;
                }
            }
        }

    }
}

// ===========================================
// 
//  GFG Editorial
// 
// =============================================


// 1) Create two temporary arrays row[M] and col[N].
//  Initialize all values of row[] and col[] as 0.
// 2) Traverse the input matrix mat[M][N]. 
// If you see an entry mat[i][j] as 1, then mark row[i] and col[j] as 1.
// 3) Traverse the input matrix mat[M][N] again.
//  For each entry mat[i][j], check the values of row[i] and col[j].
//   If any of the two values (row[i] or col[j]) is 1, then mark mat[i][j] as 1.


//Back-end complete function Template for Java

// class Solution
// {
//     //Function to modify the matrix such that if a matrix cell matrix[i][j]
//     //is 1 then all the cells in its ith row and jth column will become 1.
//     void booleanMatrix(int matrix[][])
//     {
//         int r = matrix.length;
//         int c = matrix[0].length;

//         //using two list to keep track of the rows and columns 
//         //that needs to be updated with 1.
//         int row[] = new int[r];
//         int col[] = new int[c];
        
//         for(int i = 0; i < r; i++)
//         {
//             for(int j = 0; j < c; j++)
//             {
//                 //if we get 1 in matrix, we mark ith row and jth column as 1.
//                 if(matrix[i][j] == 1){
//                     row[i] = 1;
//                     col[j] = 1;
//                 }  
//             }
//         }
        
//         for(int i =0; i < r; i++)
//         {
//             for(int j = 0; j < c; j++)
//             {
//                 //if ith row or jth column is marked as 1, then all elements
//                 //of matrix in that row and column will be 1.
//                 if(row[i] == 1 || col[j] == 1){
//                     matrix[i][j] = 1;
//                 }
//             }
//         }
//     }
// }

