/*
Give a N * N square matrix, return all the elements of its anti-diagonals from
 top to bottom.

Example 1:

Input: 
N = 2
A = [[1, 2],
     [3, 4]]
Output:
1 2 3 4
Explanation: Topmost anti-diagonal is [[1, ], 
                                       [ , ]]
Next anti-diagonal is [[ , 2], 
â€‹                       [3,  ]]
and the last anti-diagonal is [[ ,  ], 
â€‹                               [ , 4]]
Hence, elements will be returned in the 
order {1, 2, 3, 4}.
Example 2:

Input: 
N = 3 
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
Output: 
1 2 4 3 5 7 6 8 9
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function downwardDigonal()
  which takes an integer N and a 2D matrix A[ ][ ] as 
  input parameters and returns the list of all elements of
   its anti-diagonals from top to bottom.

Expected Time Complexity: O(N*N)
Expected Auxillary Space: O(N*N)

Constraints:
1 ≤ N, M ≤ 103
0 ≤ A[i][j] ≤ 106
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Print_Diagonally {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int matrix[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    static ArrayList<Integer> downwardDigonal(int n, int a[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(a[0][0]);
            return ans;
        }
        int row = 0, col = 0;

        boolean colCheck = true, rowCheck = true;
        while (true) {
            if (colCheck) {

                int i = row, j = col;
                while (i >= 0 && i < n && j >= 0 && j < n) {
                    ans.add(a[i][j]);
                    i++;
                    j--;
                }
                col++;
                if (col == n) {
                    colCheck = false;
                    row++;
                    col--;
                }
            } else if (rowCheck) {
                int i = row, j = col;
                while (i >= 0 && i < n && j >= 0 && j < n) {
                    ans.add(a[i][j]);
                    i++;
                    j--;
                }
                row++;
                if (row == n) {
                    break;
                }
            }
        }
        return ans;

    }
}
