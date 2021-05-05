/*

*/

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Row_with_max_1s {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution1().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution1 {
    int rowWithMax1s(int a[][], int n, int m) {
        int maxOne = 0;
        int maxOneIndex = -1;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (a[row][col] == 1) {
                col--;
            } else {
                int noOfOne = m - 1 - col;
                if (noOfOne > maxOne) {
                    maxOne = noOfOne;
                    maxOneIndex = row;
                }
                row++;
            }
        }
        if (col < 0) {
            int noOfOne = m - 1 - col;
            if (noOfOne > maxOne) {
                maxOne = noOfOne;
                maxOneIndex = row;
            }

        }
        return maxOneIndex;

    }
}



// ===============================
// 
// GFG Editorial
// 
// ==============================


// A simple solution would be to count total number of 1's in each row of the matrix
//  and return the index of the row having maximum 1's.

// Time Complexity : O(N * M)

// Can you optimize it further and solve it in O(N + M)?

// To solve in O(N + M) start from the top right corner of the matrix and 
// keep track of the index of the row which has maximum 1s. 
// Go left if you encounter 1
// Go down if you encounter 0
// Stop when you reach the last row or first column. 




// class Solution{
//     int rowWithMax1s(int arr[][], int n, int m) {
//         int r = 0;              // keeps track of row; starts at first row             
//         int c = m-1;            // keeps track of column; starts at last column
//         int max_row_index=-1;   // keeps track of result row index
        
//         // starting from top right corner
//         // go left if you encounter 1
//         // do down if you encounter 0
//         while(r<n && c>=0)
//         {
//             if(arr[r][c]==1)
//             {
//                 max_row_index = r;
//                 c--;
//             }
//             else
//                 r++;
//         }
//         return max_row_index;
//     }
// }