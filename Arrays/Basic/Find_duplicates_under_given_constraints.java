/*Find duplicates under given constraints 
Given a sorted array having 10 elements which contains 
6 different numbers in which only 1 number is repeated five times. 
Your task is to find the duplicate number using two comparisons only.

Examples:

Input: A[] = {1, 1, 1, 1, 1, 5, 7, 10, 20, 30}
Output: 1

Input: A[] = {1, 2, 3, 3, 3, 3, 3, 5, 9, 10}
Output: 3


Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow .
 Each test case contains 10 space separated values of the array A[].

Output:
For each test case in a new line print the required duplicate element.

Constraints:
1<=T<=100
1<=A[]<=10^5+5

Example:
Input:
2
1 2 4 5 6 9 9 9 9 9
1 2 3 3 3 3 3 5 9 10

Output:
9
3
 */

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Find_duplicates_under_given_constraints {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int[] a = new int[10];
      for (int i = 0; i < 10; i++) {
        a[i] = scan.nextInt();
      }
      if (a[0] == a[4]) {
        System.out.println(a[0] + " ");
      } else {
        System.out.println(a[5] + " ");
      }
    }
  }
}
