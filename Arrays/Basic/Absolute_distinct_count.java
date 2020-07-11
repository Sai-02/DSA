/*Given a sorted array of integers, 
return the number of distinct absolute values among the elements of the array. 

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input C[i].

Output:

Print the number of distinct absolute values.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 100
-5000 ≤ C[i] ≤ 5000

Example:

Input:

2

5

-1 -1 0 1 2

4

0 0 0 0

Output:

3

1
 */

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Absolute_distinct_count {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        k = Math.abs(k);
        if (!a.contains(k)) {
          a.add(k);
        }
      }
      System.out.println(a.size());
    }
  }
}
