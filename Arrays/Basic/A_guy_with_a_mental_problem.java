/* A guy has to reach his home and does not want to be late. 
He takes train to reach home. 
He has a mental illness, so he always switches train at every station.
For eg: If he starts with train A then at station 2 he will switch his train to train B and so on.
 Similarly, if he starts with train B then he will switch to train A at station 2 and so on. 
 Please help him to find the minimum total time he would take to reach his home.

Input:
The first line of the input contains an integer T denoting the number of test cases. 
T test cases follow. 
Each testcase contains three lines of input. 
The first line contains a positive integer N - the number of tasks to be completed. 
The second line contains N space-separated positive integers representing 
the time taken in seconds by train A to reach next Stations. 
The third line contains N space-separated positive integers 
representing the time taken in seconds by train B to reach next Stations.

Output:
For each testcase, print the minimum total time in seconds to reach home.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai, Bi <= 1010

Example:
Input:
1
3
2 1 2
3 2 1
Output:
5
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class A_guy_with_a_mental_problem {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      for (int i = 0; i < n; i++) {
        b[i] = scan.nextInt();
      }
      long sumA = 0, sumB = 0;
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          sumA = sumA + (long) a[i];
        } else {
          sumA = sumA + (long) b[i];
        }
      }
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          sumB = sumB + (long) b[i];
        } else {
          sumB = sumB + (long) a[i];
        }
      }
      sumA = Math.min(sumA, sumB);
      System.out.println(sumA);
    }
  }
}
