/* Segregate Even and Odd numbers 
Given an array A[], write a program that segregates even and odd numbers.
 The program should put all even numbers first in sorted order, and then odd numbers in sorted order.

Input:
The first line of input contains an integer T, 
denoting the number of test cases. For each testcase there will be two lines of input:
 The first line contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ...,
 AN denoting the elements of the array.

Output:
For each testcase, print the segregated array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
0 ≤A[i]<=105

Example:
Input:
2
7
12 34 45 9 8 90 3
5
0 1 2 3 4
Output:
8 12 34 90 3 9 45
0 2 4 1 3
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Segregate_Even_and_Odd_numbers {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = scan.nextInt();
      }
      Arrays.sort(A);

      ArrayList<Integer> a = new ArrayList<Integer>();

      for (int i = 0; i < n; i++) {
        int k = A[i];
        if (k % 2 == 0) {
          a.add(k);
        }
      }
      for (int i = 0; i < n; i++) {
        int k = A[i];
        if (k % 2 != 0) {
          a.add(k);
        }
      }

      for (int i = 0; i < a.size(); i++) {
        System.out.printf("%d ", a.get(i));
      }

      System.out.println("");
    }
  }
}
