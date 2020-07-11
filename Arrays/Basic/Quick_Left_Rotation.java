/* Given an array of size n and multiple values around which we need to left rotate the array.

Input:
First line consists of T test case. First line of every test case consists of N and K,
 N denoting number of elements of array and K denoting the number of places to shift.
  Second line of every test case consists of elements of array.

Output:
Single line output, print the rotated array.

Constraints:
1<=T<=100
1<=N<=10^4
1<=K<=10^4

Example:
Input:
1
5 14
1 3 5 7 9
Output:
9 1 3 5 7
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Quick_Left_Rotation {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      if (k > n) {
        k = k % n;
      }
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      for (int i = k; i < n; i++) {
        System.out.printf("%d ", a[i]);
      }
      for (int i = 0; i < k; i++) {
        System.out.printf("%d ", a[i]);
      }
      System.out.println("");
    }
  }
}
