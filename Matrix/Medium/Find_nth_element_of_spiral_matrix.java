/*
Given a matrix with n rows and m columns.
 Your task is to find the kth element which is obtained while
  traversing the matrix spirally. You need to complete the method 
  findK which takes four arguments the first argument is the matrix
   A and the next two arguments will be n and m denoting the size of
    the matrix A and then the forth argument is an integer  k denoting the kth element .
     The function will return the kth element obtained while traversing the matrix 
     spirally.


Example 1:

Input:
n = 3, m = 3, k = 4
A[][] = {{1 2 3},
         {4 5 6},
         {7 8 9}}
Output:
6
Explanation:
The matrix above will look like 
1 2 3
4 5 6
7 8 9
and the 4th element in spiral fashion
will be 6 .

Your Task:
You only need to implement the given function findK(). 
Do not read input, instead use the arguments given in the function. 
Return the K'th element obtained by traversing matrix spirally.


Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)


Constraints:
1<=n,m<=20
1<=k<=n*m
 */

// { Driver Code Starts
import java.util.*;

public class Find_nth_element_of_spiral_matrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[1000][1000];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(new GfG().findK(arr, n, m, k));
            t--;
        }
    }
}// } Driver Code Ends

class GfG {
    /* You are required to complete this method */
    int findK(int a[][], int n, int m, int k) {
        int count = 0;
        int maxRow = n - 1, maxCol = m - 1, minRow = 0, minCol = 0;

        for (;;) {
            for (int j = minCol; j <= maxCol; j++) {
                count++;
                if (count == k) {
                    return a[minRow][j];
                }
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++) {
                count++;
                if (count == k) {
                    return a[i][maxCol];
                }
            }
            maxCol--;
            for (int j = maxCol; j >= minCol; j--) {
                count++;
                if (count == k) {
                    return a[maxRow][j];
                }
            }
            maxRow--;
            for (int i = maxRow; i >= minRow; i--) {
                count++;
                if (count == k) {
                    return a[i][minCol];
                }
            }
            minCol++;
        }
        // return -1;

    }
}
