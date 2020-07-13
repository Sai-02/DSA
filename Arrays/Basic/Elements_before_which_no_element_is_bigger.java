/* You are given an array A of size N. 
The task is to find count of elements before which all the elements are smaller. 
First element is always counted as there is no other element before it.

Input:
The first line of input will contain number of test cases T .
 Then T test cases follow . Each test case contains 2 lines on input. 
 The first line contains an integer N denoting the number of elements in the array.
  The next line contains N space separated integer's denoting the elements of the array.

Output:
For each test case, print the Number of Elements before which no element is bigger.

Constraints:
1 <= T<= 100
1 <= N <= 107
 1<= Ai <=1018

Example:
Input
2
6
10 40 23 35 50 7
3
5 4 1
Output
3
1
Explanation
Test Case 1:
Input: arr[] =  {10, 40, 23, 35, 50, 7}
Output: 3
The elements are 10, 40 and 50.
No of elements is 3
Test Case 2:
Input: arr[] = {5, 4, 1}
Output: 1
There is only one element 5
No of element is 1
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Elements_before_which_no_element_is_bigger {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      long[] a = new long[n];
      long max = Long.MIN_VALUE, count = 0;
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextLong();
        if (max < a[i]) {
          count++;
          max = a[i];
        }
      }
      System.out.println(count);
    }
  }
}
