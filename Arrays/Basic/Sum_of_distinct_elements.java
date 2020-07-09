/* Sum of distinct elements 
You are given an array of size N. Find the sum of distinct elements in an array.

Input:
The first line of input contains an integer T denoting the number of test cases.
 T testcases follow. Each testcase contains two lines of input:
The first line is N, the size of array.
The second line contains N elements separated by spaces.

Output:
For each testcase, print the sum of all distinct elements.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 103

Example:
Input:
3
5
1 2 3 4 5
5
5 5 5 5 5
4
22 33 22 33
Output:
15
5
55
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Sum_of_distinct_elements {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> b = new ArrayList<Integer>();

      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (!b.contains(k)) {
          b.add(k);
        }
      }
      int sum = 0;
      for (int i = 0; i < b.size(); i++) {
        sum = sum + b.get(i);
      }
      System.out.println(sum);
    }
  }
}
