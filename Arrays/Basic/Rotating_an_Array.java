/* Given an array of N size. 
The task is to rotate array by d elements where d is less than or equal to N.

Input:
The first line of input contains a single integer T denoting the number of test cases. 
Then T test cases follow. Each test case consist of three lines.
 The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.
 The third line of each test case contains "d" .

Output:
Corresponding to each test case, in a new line, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 200
1 ≤ A[i] ≤ 1000

Example:
Input
1
5
1 2 3 4 5
2

Output
3 4 5 1 2 
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Rotating_an_Array {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> a = new ArrayList<Integer>();

      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        a.add(k);
      }
      int d = scan.nextInt();
      for (int i = 1; i <= d; i++) {
        int temp = a.get(0);
        a.remove(0);
        a.add(temp);
      }
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", a.get(i));
      }
      System.out.println("");
    }
  }
}
