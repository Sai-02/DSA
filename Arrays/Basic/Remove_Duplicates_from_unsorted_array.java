/* Given an array of integers which may or may not contain duplicate elements. 
Your task is to print the array after removing duplicate elements, if present.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. 
 Each test case contains an integer n denoting the size of the array.
  Then following line contains 'n' integers forming the array.

Output:
Output the array with no duplicate element present, in the same order as input.

Constraints:
1<=T<=100
1<=n<=100
1<=a[i]<=100

Example:
Input:
1
6
1 2 3 1 4 2
Output:
1 2 3 4
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Remove_Duplicates_from_unsorted_array {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (!a.contains(k)) {
          a.add(k);
          System.out.printf("%d ", k);
        }
      }
      System.out.println("");
    }
  }
}
