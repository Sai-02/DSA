/* Index of first 1 in a sorted array of 0’s and 1’s 
Given a sorted array consisting 0’s and 1’s. 
The task is to find the index of first ‘1’ in the given array.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines. 
 First line of each test case contains an Integer N denoting size of array
  and the second line contains N space separated 0 and 1.

Output:
For each test case, in a new line print the index of first 1. 
If 1 is not present in the array then print “-1”.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Ai <= 1018

Example:
Input:
2
10
0 0 0 0 0 0 1 1 1 1
4
0 0 0 0

Output:
6
-1

Explanation:
Testcase 1: First index where 1 is presented is 6.
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Index_of_first_1_in_a_sorted_array_of_0s_and_1s {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int i;
      for (i = 0; i < n; i++) {
        if (a[i] == 1) {
          break;
        }
      }
      if (i == n) {
        i = -1;
      }
      System.out.println(i);
    }
  }
}
