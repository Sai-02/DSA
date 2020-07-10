/* Given an array of integers,
 task is to print the array in the order – 
 smallest number, Largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number 
 and so on..

Input:
The first line consists of an integer T i.e number of test cases. 
The first line of each test case consists of an integer N.
The next line consists of N spaced integers. 

Output:
Print the required answer.

Constraints: 
1<=T<=100
1<=N,a[i]<=1000

Example:
Input:
2
9
1 9 2 8 3 7 4 6 5
4
1 2 3 4 

Output:
1 9 2 8 3 7 4 6 5
1 4 2 3
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Rearrange_the_array {

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
      if (n == 1) {
        System.out.printf("%d", a[0]);
      } else {
        for (int i = 0; i < n / 2; i++) {
          System.out.printf("%d %d ", a[i], a[n - 1 - i]);
        }
        if (n % 2 == 0) {
          System.out.printf("%d", a[n / 2]);
        }
      }

      System.out.println("");
    }
  }
}
