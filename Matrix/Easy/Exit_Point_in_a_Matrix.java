/*
Given a matrix of size n x m with 0’s and 1’s ,
 you enter the matrix at cell (0,0) in left to right direction.
  whenever you encounter a 0 you retain in same direction ,
   if you encounter a 1’s you have to change direction to right of current direction
    and change that 1 value to 0, you have to find out from which index 
    you will leave the matrix at the end.
 

Example 1:

Input: matrix = {{0, 1, 0},
{0, 1, 1}, {0, 0, 0}}
Output: 1 0
Explanation: We enter at 0,0 then move towards 
0,1 and we encountered a 1 so we turned right 
and moved towards 1,1 and again we encountered 
a 1 so we turned right and moved towards 1,0 after
which we leave the matrix.
Example 2:

Input: matrix = {{0, 0}}
Output: 0 1
 

Your Task:
You don't need to read or print anyhting.
 Your task is to complete the function FindExitPoint()
  which takes the matrix as input parameter and returns
   a list containg the exit point.
 

Expected Time Complexity: O(n * m) where n is number of rows and m is number of columns.

Expected Space Complexity: O(1)
 

Constraints:
1 <= n, m <= 100
 */
// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Exit_Point_in_a_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(matrix);
            for (int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int[] FindExitPoint(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean right = true, up = false, down = false, left = false;
        int ans[] = new int[2];
        int row = 0, col = 0;
        while (row >= 0 && row < n && col < m && col >= 0) {
            if (matrix[row][col] == 0) {
                if (right) {
                    col++;

                } else if (left) {
                    col--;
                } else if (up) {
                    row--;
                } else if (down) {
                    row++;
                }
            } else {
                matrix[row][col] = 0;
                if (right) {
                    up = false;
                    left = false;
                    right = false;
                    down = true;
                } else if (left) {
                    up = true;
                    left = false;
                    right = false;
                    down = false;

                } else if (up) {
                    right = true;
                    left = false;
                    down = false;
                    up = false;
                } else if (down) {
                    left = true;
                    right = false;
                    up = false;
                    down = false;

                }
            }

        }
        if (row == n) {
            row--;
        } else if (row < 0) {
            row++;
        }
        if (col == m) {
            col--;
        } else if (col < 0) {
            col++;
        }
        ans[0] = row;
        ans[1] = col;
        return ans;

    }
}
