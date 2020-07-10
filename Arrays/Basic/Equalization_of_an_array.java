/* Given an array of integers,
 the task is to count minimum number of operations to equalize the array 
 i.e., to make all array elements same. 
 To equalize an array, we need to move values from higher numbers to smaller numbers.
  Number of operations is equal to number of movements.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines. 
 First line of each test case contains an Integer N denoting size of array and 
 the second line contains N space separated elements.

Output:
For each test case, print the minimum number of operations. And print "-1",
 if it is not possible to equalize the array.

Constraints:
1<=T<=100
1<=N<=105
0<=A[i]<=105

Example:
Input:
2
5
1 3 2 0 4
3
1 7 1
Output:
3
4
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Equalization_of_an_array {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
        sum = sum + a[i];
      }
      if (sum % n != 0) {
        System.out.println("-1");
      } else {
        int k = sum / n;
        sum = 0;
        for (int i = 0; i < n; i++) {
          int s = Math.abs(k - a[i]);
          sum = sum + s;
        }
        sum = sum / 2;
        System.out.println(sum);
      }
    }
  }
}
