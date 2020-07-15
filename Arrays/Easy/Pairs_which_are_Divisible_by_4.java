/*Given an array if ‘n’ positive integers, 
count number of pairs of integers in the array that have the sum divisible by 4.

Input:

The first line of the input contains a single integer T, 
denoting the number of test cases. 
Then T test case follows.
 Each test-case has two lines of the input,
  the first line contains an integer denoting 
  the size of an array N and the second line of input contains N positive integers.
Output:

Print the number of pairs of integers in the array that have the sum divisible by 4.
Constraints:

1<=T<=100

1<=N<=100

1<=arr[]<=1000
Example:

Input:

2

5

2 2 1 7 5

5

2 2 3 5 6

Output:

3

4

Explanation:

Testcase 1: (2,2), (1,7) and(7,5) are the 3 pairs.

Testcase 2: (2,2), (2,6), (2,6), (3,5) are the 4 pairs.
 */

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Pairs_which_are_Divisible_by_4 {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j) {
            int s = a[i] + a[j];
            if (s % 4 == 0) {
              count++;
            }
          }
        }
      }
      count = count / 2;
      System.out.println(count);
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
