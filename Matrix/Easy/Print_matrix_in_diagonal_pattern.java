/*
Given a matrix M of n*n size, the task is to complete the function which prints 
its elements in diagonal pattern as depicted below.



Example 1:

Input:
N = 3
mat[][] = {{1 2 3},{4 5 6},{7 8 9}}
Output: 1 2 4 7 5 3 6 8 9
Example 2:

Input:
N = 2
mat[][] = {{1 2},{3 4}}
Output: 1 2 3 4
Your Task:
You only need to implement the given function matrixDiagonally()
 which returns a list containing the matrix diagonally..
  Do not read input, instead use the arguments given in the function. 
  Print the elements in Matrix in diagonal pattern.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
Constraints:
1<=N<=100

Note:The Input/Ouput format and Example given are used 
for system's internal purpose, and should be used by a
 user for Expected Output only. As it is a function problem,
  hence a user should not read any input from stdin/console. 
  The task is to complete the function specified,
 and not to write the full code.
 */

// { Driver Code Starts
import java.io.*;

public class Print_matrix_in_diagonal_pattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for (int k = 0; k < S.length; k++) {
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if (j == n) {
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for (int it = 0; it < ans.length; it++) {
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int a[] = new int[n * n];
        int row = 0, col = 0;
        for (int i = 0; i < n * n; i++) {
            a[i] = mat[row][col];
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == n - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return a;
    }
}