/* Given an array A of size N. Print all the numbers less than K in the array. The numbers should be such that the difference between every adjacent digit should be 1.

Note: Print '-1' if no number if valid.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. Each testcase contains two lines of input. The first line consists of two integers N and K separated by a space. The next line consists of N spaced integers. 

Output:
For each testcase, print the required output.

Constraints: 
1 <= T <= 100
1 <= N <= 107
1 <= K, A[i] <= 1018

Example:
Input:
2
8 54
7 98 56 43 45 23 12 8
10 1000
87 89 45 235 465 765 123 987 499 655

Output:
43 45 23 12
87 89 45 765 123 987

Explanation:
Testcase1: 43 45 23 12  all these numbers have adjacent digits diff as 1 and they are less than 54
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Absolute_Difference_of_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int k = scan.nextInt();

      int p = 0;
      for (int i = 0; i < n; i++) {
        long num = scan.nextLong();
        if (num < k && num >= 10) {
          String s = "" + num;
          int j;
          for (j = 0; j < s.length() - 1; j++) {
            int d1 = (int) s.charAt(j);
            int d2 = (int) s.charAt(j + 1);
            d1 = Math.abs(d1 - d2);
            if (d1 == 1) {
              continue;
            } else {
              break;
            }
          }
          if (j == s.length() - 1) {
            System.out.printf("%d ", num);
            p++;
          }
        }
      }
      if (p == 0) {
        System.out.printf("-1");
      }
      System.out.println("");
    }
  }
}
