/* Chunky gets happy by eating Melody.
Given an array of N elements each element represent happiness chunky get by eating melody.
Chunky knows why melody is so chocolaty but will only tell you once you tell him the Max happiness he can get by eating two adjacent melodies.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines. 
 First line of each test case contains an integer N and the second line contains N space separated array elements.

Output:
For each test case, print the Maximum Happiness in new line.

Constraints:
1 <= T <= 100
1 <= N <= 100000
-100000 <= A[i] <= 100000
 

Example:

Input:
2
5
1 2 3 4 5
4
5 2 3 4

Output:
9
7
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Why_is_Melody_so_chocolaty {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n - 1; i++) {
        int k = a[i] + a[i + 1];
        if (k > max) {
          max = k;
        }
      }
      System.out.println(max);
    }
  }
}
