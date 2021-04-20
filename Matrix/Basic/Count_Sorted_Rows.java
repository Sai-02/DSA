/*
Given two integers N and M and a matrix of dimensions N*M.
 Count all the rows in a matrix that are sorted either in strictly 
 increasing order or in strictly decreasing order.

Example 1:

Input:
N=3,M=3
Mat=[[1,2,3],[6,5,4],[7,9,8]]
Output:
2
Explanation:
The first row is sorted in strictly 
increasing order while the second row 
is sorted in strictly decreasing order.
Example 2:

Input:
N=3,M=3
Mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
3
Explanation:
All the rows are sorted in strictly 
increasing order.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function sortedCount() 
which takes the two integers N,M and the matrix Mat as
 input parameters and returns the number of rows which 
 are sorted in either strictly increasing order or strictly decreasing order.


Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(1)
 

Constraints:
1<=N,M,Mat[i][j]<=1000
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Count_Sorted_Rows {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution3 ob = new Solution3();
            System.out.println(ob.sortedCount(N, M, Mat));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution3 {
    int sortedCount(int n, int m, int a[][]) {
        int rows = 0;
        for (int i = 0; i < n; i++) {
            boolean increase = false, decrease = false;
            for (int j = 1; j < m; j++) {
                if (a[i][j] > a[i][j - 1]) {
                    increase = true;
                } else if (a[i][j] < a[i][j - 1]) {
                    decrease = true;
                } else {
                    increase = true;
                    decrease = true;
                }

            }
            if (!(increase && decrease)) {
                rows++;
            }
        }
        return rows;
    }
};