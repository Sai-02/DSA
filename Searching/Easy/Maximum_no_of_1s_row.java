/*
Given a boolean 2D array, where each row is sorted. 
Find the row with the maximum number of 1s.

Example 1:

Input:
N = 3, M = 4
Mat[] = {{0 1 1 1},
         {0 0 1 1},
         {0 0 1 1}}
Output: 0
Explanation: Row 0 has 3 ones whereas
rows 1 and 2 have just 2 ones.

â€‹Example 2:

Input: 
N = 2, M = 2
Mat[] = {{0 1},
         {1 1}}
Output: 1
Explanation: Row 1 has 2 ones whereas
row 0 has just a single one. 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function maxOnes ()
  which takes a 2D array Mat[][] and its dimensions
   N and M as inputs and returns the row index with the maximum number
    of 1s (0-based index). If there are multiple rows with the maximum number of ones, 
    then return the row with the smaller index.


Expected Time Complexity: O(NLogM).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N, M <= 40
0 <= M[ ][ ] <= 1

Company Tags
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Maximum_no_of_1s_row {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt();

            System.out.println(new Sol14().maxOnes(arr, n, m));
        }

    }
}// } Driver Code Ends

class Sol14 {

    public static int maxOnes(int a[][], int N, int M) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < N; i++) {
            int l = 0, r = M - 1;
            int min = Integer.MAX_VALUE;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (a[i][mid] == 0) {
                    l = mid + 1;
                } else {
                    min = Integer.min(min, mid);
                    r = mid - 1;
                }
            }
            if ((M - min) > max) {
                max = M - min;
                maxIndex = i;
            }
        }
        return maxIndex;

    }
}

// ====================================================================
// 
// GFG Editorial
// 
// ===================================================================


// Brute force would be to traverse all the cells of each row and
//  calculate the total number of ones in each row. But, this approach would be O(nm).

// Can you make the use of the fact that all the rows are sorted in non-decreasing order
// . That is, all zeros appear first, followed by all the ones.
//  Can you Binary Search on a row to find the index of the leftmost 1 present in it?



// class Sol
// {
//     public static int maxOnes (int arr[][], int n, int m)
//     {
//         int res = 0, row = 0, sp, ep, mid, cur;
    
//         for (int i = 0; i < n; i++)
//         {
//             sp = 0;
//             ep = m-1;
//             cur = m-1;
            
//             // applying binary search on the current row
//             while (sp <= ep)
//             {
//                 mid = (sp + ep) / 2;
//                 if (arr[i][mid] == 1)
//                 {
//                     cur = mid;
//                     ep = mid-1;
//                 }
//                 else sp = mid+1;
//             }
            
//             if (m-1 - cur > res)
//             {
//                 res = m-1 - cur;
//                 row = i;
//             }
//         }
//         return row;
//     }
// }
