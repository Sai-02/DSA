/*
Greater on right side 
You are given an array A of size N. 
Replace every element with the next greatest element (greatest element on its right side) in the array.
 Also, since there is no element next to the last element, replace it with -1.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. 
Each testcase contains two lines of input. The first line is N, the size of tha array. 
The second line contains N space separated integers.

Output:
For each testcase, print the modified array.

Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= Ai <= 1000

Example:
Input:
2
6
16 17 4 3 5 2
4
2 3 1 9

Output:
17 5 5 5 2 -1
9 9 9 -1

Explanation:
Testcase1: For 16 the greatest element on its right is 17. For 17 it's 5. 
For 4 it's 5. For 3 it's 5. For 5 it's 2.
 For 2 it's -1(no element to its right).
  So the answer is 17 5 5 5 2 -1
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class Greater_on_right_side {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int[] b = new int[n];
      int j = 0;
      for (int i = 0; i < n; i++) {
        int max = 0;
        for (j = i + 1; j < n; j++) {
          if (max < a[j]) {
            max = a[j];
          }
        }
        b[i] = max;
      }
      b[n - 1] = -1;
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", b[i]);
      }
      System.out.println("");
    }
  }
}
