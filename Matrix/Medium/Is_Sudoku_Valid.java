/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix(mat[][]) 
the task to check if the current configuration is valid or not where a 0 represents
 an empty block.
Note: Current valid configuration does not ensure validity of the final solved sudoku. 
Refer to this : https://en.wikipedia.org/wiki/Sudoku

Example 1:

Input: mat[][] = [
[3, 0, 6, 5, 0, 8, 4, 0, 0]
[5, 2, 0, 0, 0, 0, 0, 0, 0]
[0, 8, 7, 0, 0, 0, 0, 3, 1]
[0, 0, 3, 0, 1, 0, 0, 8, 0]
[9, 0, 0, 8, 6, 3, 0, 0, 5]
[0, 5, 0, 0, 9, 0, 6, 0, 0]
[1, 3, 0, 0, 0, 0, 2, 5, 0]
[0, 0, 0, 0, 0, 0, 0, 7, 4]
[0, 0, 5, 2, 0, 6, 3, 0, 0]
]
Output: 1
Explaination: It is possible to have a
proper sudoku.
Your Task:
You do not need to read input or print anything. 
Your task is to complete the function isValid() which takes mat[][] 
as input parameter and returns 1 if any solution is possible. Otherwise, returns 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ mat[i][j] ≤ 9
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Is_Sudoku_Valid {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for (int i = 0; i < 81; i++)
                mat[i / 9][i % 9] = Integer.parseInt(s1[i]);

            Solution4 ob = new Solution4();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution4 {
    static int isValid(int a[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> h = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0) {
                    if (h.contains(a[i][j])) {
                        return 0;
                    } else {
                        h.add(a[i][j]);
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            HashSet<Integer> h = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (a[i][j] != 0) {
                    if (h.contains(a[i][j])) {
                        return 0;
                    } else {
                        h.add(a[i][j]);
                    }
                }
            }
        }

        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                HashSet<Integer> h = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (a[i][j] != 0) {
                            if (h.contains(a[i][j])) {
                                return 0;
                            } else {
                                h.add(a[i][j]);
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }
}
// =====================================
// 
// GFG Editorial
// 
// =====================================


// class Solution{
//     public int isValid(int mat[][]){
//         int r[][]=new int[9][9];
//         int c[][]=new int[9][9];
//         int s[][][]=new int[3][3][9];
        
    
//         int number;
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (mat[i][j] > 0 && mat[i][j] <= 9) {
//                     number = mat[i][j] - 1;
//                     if (r[i][number]!=0) 
//                         return 0;
//                     r[i][number] = 1;
//                     if (c[j][number]!=0) 
//                         return 0;
//                     c[j][number] = 1;
//                     // checking if same box have repeated value except for 0
//                     if (s[i / 3][j / 3][number] !=0) 
//                         return 0;
//                     s[i / 3][j / 3][number] = 1;
//                 }
//             }
//         }
//         return 1;
//     }
// };