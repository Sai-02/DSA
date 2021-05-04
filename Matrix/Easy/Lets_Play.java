/*
Let's play a game!! Given a matrix mat[][] with n x m elements.
 Your task is to check that matrix is Super Similar or not. 
 
 To perform this task you have to follow these Rules: Firstly 
 all even index rows to be Rotated left and odd index rows to right,
  And Rotation is done X times(Index starting from zero). Secondly,
   After all the Rotations check if the initial and the final Matrix 
   are same Return 1 else 0.


Example 1:

Input: n = 2, m = 2
mat = {{1, 2}, 
       {5, 6}}
x = 1
Output: 0
Explanation: After one rotation mat is 
not same as the previous one.
 

Example 2:

Input: n = 2, m = 4
mat = {{1, 2, 1, 2}, 
       {2, 1, 2, 1}}
x = 2
Output: 1
Explanation: After two rotation mat is 
same as the previous one.

Your Task:
You do not need to read input or print anything. 
Your task is to complete the function isSuperSimilar() 
which takes n, m, x and the matrix as input parameter and 
returns 1 if the initial and the final Matrix are same else returns 0.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)


Constraints:
1 ≤ n, m ≤ 30
1 ≤ mat[i][j] ≤ 100 
1 ≤ x ≤ 20
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Lets_Play {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String arr[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for (int i = 0; i < n * m; i++)
                mat[i / m][i % m] = Integer.parseInt(arr[i]);
            int x = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isSuperSimilar(n, m, mat, x));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    static int isSuperSimilar(int n, int m, int mat[][], int x) {
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = mat[i][j];
            }
        }
        x = x % m;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int k = m - x;
                reverse(a[i], m - k, m - 1);
                reverse(a[i], 0, m - k - 1);
                reverse(a[i], 0, m - 1);

            } else {
                reverse(a[i], m - x, m - 1);
                reverse(a[i], 0, m - x - 1);
                reverse(a[i], 0, m - 1);

            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != mat[i][j]) {
                    return 0;
                }

            }
        }

        return 1;

    }

    static void reverse(int a[], int i, int j) {
        if (i < 0) {
            return;
        }
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }
    }
}