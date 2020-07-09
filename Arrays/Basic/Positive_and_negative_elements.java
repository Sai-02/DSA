/*Given an array containing equal number of positive and negative elements, 
arrange the array such that every positive element is followed by a negative element.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines.
  First line of each test case contains an Integer N denoting size of array and 
  the second line contains N space separated elements.

Output:
For each test case, in a new line print the arranged array.

Constraints:
1 <= T <= 300
2 <= N <= 105
-105 <= A[i] <= 105

Example:
Input:
2
6
-1 2 -3 4 -5 6
4
-3 2 -4 1
Output:
2 -1 4 -3 6 -5
2 -3 1 -4 
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Positive_and_negative_elements {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      int pos = 0;
      int neg = 1;
      int N = sc.nextInt();
      int[] B = new int[N];
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
        if (A[i] >= 0) {
          B[pos] = A[i];
          pos = pos + 2;
        } else if (A[i] < 0) {
          B[neg] = A[i];
          neg = neg + 2;
        }
      }
      for (int i = 0; i < N; i++) {
        System.out.print(B[i] + " ");
      }
      System.out.println();
      T--;
    }
  }
}
