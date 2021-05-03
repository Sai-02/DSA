/*
Given a matrix mat[][] of n rows and m columns, consisting of 0’s and 1’s.
 The task is to complete the function findPerimeter which returns an integer
  denoting the perimeter of sub-figures consisting of only 1’s in the matrix.

For example
Perimeter of single 1 is 4 as it can be covered from all 4 side.
 Perimeter of double 11 is 6.

                            
|  1  |           |  1    1  |
                            

Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow. The first line of each test case contains two space
 separated n and m denoting the size of the matrix mat[][] . 
 Then in the next line are n*m space separated values of the matrix.

Output:
For each test case in a new line print the perimeter of sub-figure consisting 
only 1’s in the matrix.

Constraints:
1<=T<=100
1<=n, m<=20

Example(To be used for expected output):
Input:
2
1 2
1 1 
3 3
1 0 0 1 0 0 1 0 0

Output:
6
8


 */

// { Driver Code Starts
import java.util.*;

public class Find_perimeter_of_shapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = sc.nextInt();
            GfG g = new GfG();
            System.out.println(g.findPerimeter(a, n, m));
        }
    }
}// } Driver Code Ends

/* Complete the function given below */
class GfG {
    public static int findPerimeter(int[][] a, int n, int m) {
        int perimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    if (i == 0 || a[i - 1][j] == 0) {
                        perimeter++;
                    }
                    if (i == n - 1 || a[i + 1][j] == 0) {
                        perimeter++;
                    }
                    if (j == 0 || a[i][j - 1] == 0) {
                        perimeter++;
                    }
                    if (j == m - 1 || a[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }

        }

        return perimeter;
    }

}