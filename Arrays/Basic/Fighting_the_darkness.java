/* You are given an array A representing size of candles which reduce 1 unit in a day. 
Room is illuminated using given x candles, where x is the size of array A.
 Question is to find maximum number of days room is without darkness.

Input:
The first line of input consists of an integer T denoting the number of test cases. 
T testcases follow. 
Each test case contains an integer N denoting the size of the array.
 Then in the next line are N space separated elements of the array.

Output:
For each test case, print the maximum number of days room will be illuminated.

Constraints:
1<=T<=200
1<=N<=107
1<=Elements of array <=1018

Example:
Input:
2
3
1 1 2
5
2 3 4 1 2
Output:
2
4

Explanation:
Testcase1: The candles' length reduce by 1 in 1 day.
So, at the end of day 1: Sizes would be 0 0 1
So, at end of day 2: Sizes would be 0 0 0.
This means the room was illuminated for 2 days.
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Fighting_the_darkness {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();

      long max = Long.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        long k = scan.nextLong();
        if (max < k) {
          max = k;
        }
      }
      System.out.println(max);
    }
  }
}
