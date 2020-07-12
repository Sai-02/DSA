/* Given an array A of size N, 
the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= N.
 Find the maximum repeating number in this array.
  If there are two or more maximum repeating numbers print the element having least value.

Input:
The first line of input contains an integer T, 
denoting the number of test cases. 
T testcases follow. 
Each testcase contains two lines of input. 
First line contains N and k, both separated by a space.
 The next line contains N integers separated by spaces.

Output:
For each testcase, in a new line, print the maximum frequency element.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= k <= N
0 <= Ai <= k-1

Example:
Input:

2
4 3
2 2 1 2
6 3
2 2 1 0 0 1
Output:
2
0

Explanation:

Testcase1: 2 is the most frequent element.
Testcase2: 0 1 and 2 all have same frequency of 2. But since 0 is smallest, we print that.
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Maximum_repeating_number {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      Arrays.sort(a);
      ArrayList<Integer> num = new ArrayList<Integer>();
      ArrayList<Integer> c = new ArrayList<Integer>();
      int pre = a[0];
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (n == 1) {
          num.add(a[i]);
          c.add(1);
          break;
        }
        if (i == 0) {
          pre = a[i];
          count = 1;
        } else {
          int now = a[i];
          if (now == pre) {
            count++;
          } else {
            num.add(pre);
            c.add(count);
            count = 1;
            pre = a[i];
          }
        }
        if (i == n - 1) {
          num.add(pre);
          c.add(count);
        }
      }
      int max = 0;
      count = Integer.MIN_VALUE;
      for (int i = 0; i < num.size(); i++) {
        if (c.get(i) > count) {
          count = c.get(i);
          max = num.get(i);
        } else if (c.get(i) == count) {
          max = Math.min(max, num.get(i));
        }
      }
      System.out.println(max);
    }
  }
}
