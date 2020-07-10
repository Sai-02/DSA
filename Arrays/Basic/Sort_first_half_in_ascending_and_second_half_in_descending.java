/* Given an array of integers, sort the first half of the array in ascending order and second half in descending order.

Input:
The first line consists of an integer T i.e number of test cases.
 The first line of each test case consists of an integers N.
 The next line consists of N spaced integers. 

Output:
Print the required output.

Constraints: 
1<=T<=100
1<=N<=100
1<=a[i]<=1000

Example:
Input:
2
9
5 2 4 7 9 3 1 6 8
6
1 2 3 4 5 6

Output:
1 2 3 4 9 8 7 6 5
1 2 3 6 5 4
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Sort_first_half_in_ascending_and_second_half_in_descending {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      Arrays.sort(a);
      for (int i = 0; i < n / 2; i++) {
        System.out.printf("%d ", a[i]);
      }
      if (n % 2 == 0) {
        for (int i = n - 1; i >= n / 2; i--) {
          System.out.printf("%d ", a[i]);
        }
      } else {
        for (int i = n - 1; i >= n / 2; i--) {
          System.out.printf("%d ", a[i]);
        }
      }
      System.out.println("");
    }
  }
}
