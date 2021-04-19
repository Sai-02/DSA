/*
Given a matrix of size N x N. Print the elements of the matrix in the snake 
like pattern depicted below.


Example 1:

Input:
N = 3 
matrix[][] = {{45, 48, 54},
             {21, 89, 87}
             {70, 78, 15}}
Output: 45 48 54 87 89 21 70 78 15 
Explanation:
Matrix is as below:
45 48 54
21 89 87
70 78 15
Printing it in snake pattern will lead to 
the output as 45 48 54 87 89 21 70 78 15.
Example 2:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 1 2 4 3
Explanation:
Matrix is as below:
1 2 
3 4
Printing it in snake pattern will 
give output as 1 2 4 3.

Your Task:
You dont need to read input or print anything.
 Complete the function snakePattern() that takes matrix
  as input parameter and returns a list of integers in 
  order of the values visited in the snake pattern. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(N * N) for the resultant list only.

Constraints:
1 <= N <= 100
1 <= mat[i][j] <= 100
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Print_Matrix_in_snake_Pattern {
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
            ArrayList<Integer> ans = ob.snakePattern(matrix);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int a[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    ans.add(a[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    ans.add(a[i][j]);
                }

            }
        }
        return ans;
    }
}