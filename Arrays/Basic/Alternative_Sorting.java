/*Alternative Sorting 
Given an array Arr[] of N distinct integers,
 print the array in such a way that 
 the first element is first maximum and 
 second element is first minimum and so on.

Input:
First line of input contains a single integer T which denotes the number of test cases. 
Then T test case follows. 
First line of each test case contains a single integer N which denotes the number of elements in the array. 
Second line of each test case contains N space separated integers.

Output:
For each test case print the given array in such a way
 that the first element is first maximum and second element is first minimum and so on.

Constraints:
1<=T<=100
1<=N<=104
1<=Arr[i]<=105

Example:
Input:
2
7
7 1 2 3 4 5 6
8
1 6 9 4 3 7 8 2
Output:
7 1 6 2 5 4 3
9 1 8 2 7 3 6 4
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Alternative_Sorting {

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
      ArrayList<Integer> b = new ArrayList<Integer>();
      if (n % 2 == 0) {
        for (int i = 0; i < n / 2; i++) {
          b.add(a[n - 1 - i]);
          b.add(a[i]);
        }
      } else {
        for (int i = 0; i < (n / 2) + 1; i++) {
          b.add(a[n - 1 - i]);
          b.add(a[i]);
        }
        int temp = b.get(n - 1);
        b.remove(n - 1);
        b.add(temp);
      }
      for (int i = 0; i < n; i++) {
        System.out.printf(b.get(i) + " ");
      }
      System.out.println("");
    }
  }
}
