/*
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. 
Complete the function spirallyTraverse() that takes 
matrix, r and c as input parameters and returns a list
 of integers denoting the spiral traversal of matrix. 

Expected Time Complexity: O(r*c)
Expected Auxiliary Space: O(r*c)

Constraints:
1 <= r, c <= 100
0 <= matrixi <= 100
 */

// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Spirally_traversing_a_matrix {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution3 ob = new Solution3();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

class Solution3 {
    // Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c) {
        ArrayList<Integer> ans = new ArrayList<>();
        int minRow = 0, minCol = 0, maxRow = r - 1, maxCol = c - 1;

        for (int count = 0; count < r * c;) {
            for (int j = minCol; j <= maxCol; j++) {
                if (count == (r * c)) {
                    return ans;
                }

                ans.add(a[minRow][j]);
                count++;
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++) {
                if (count == (r * c)) {
                    return ans;
                }

                ans.add(a[i][maxCol]);
                count++;
            }
            maxCol--;
            for (int j = maxCol; j >= minCol; j--) {
                if (count == (r * c)) {
                    return ans;
                }

                ans.add(a[maxRow][j]);
                count++;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow; i--) {
                if (count == (r * c)) {
                    return ans;
                }

                ans.add(a[i][minCol]);
                count++;
            }
            minCol++;

        }
        return ans;
    }
}
