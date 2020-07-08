/*Pair array product sum 
Given a array a[] of non-negative integers.
 Count the number of pairs (i, j) in the array such that a[i] + a[j] < a[i]*a[j].
  (the pair (i, j) and (j, i) are considered same and i should not be equal to j)

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow.
 Each test case contains an integer n denoting the size of the array. 
The next line contains n space separated integers respectively forming the array.

Output:
Print the total number of pairs possible in the array according to the problem statement.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5

Example:
Input:
2
3
3 4 5
3
1 1 1 

Output:
3
0
 */

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Pair_array_product_sum {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int sum = 0;
      boolean[][] bool = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          bool[i][j] = false;
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (a[i] + a[j] < (a[i] * a[j]) && !bool[i][j] && i != j) {
            sum++;
            bool[i][j] = true;
            bool[j][i] = true;
          }
        }
      }

      System.out.println(sum);
    }
  }
}
