/* You are given an array of size N having no duplicate elements.
 The array can be categorized into following:
1.  Ascending
2.  Descending
3.  Descending Rotated
4.  Ascending Rotated
Your task is to print which type of array it is and the maximum element of that array.

Input:
The first line of input contains an integer T denoting the no test cases.
 Then T test caes follow. Each testcase contains two lines of input. 
 The first line contains an integer N denoting the size of the array.
  The next line contains N space separated values of the array.

Output:
For each test case, print the largest element in the array and and integer x denoting the type of the array.

Constraints:
1 <= T <= 100
3 <= N <= 107
1 <= A[] <= 1018

Example:
Input:
2
5
2 1 5 4 3
5
3 4 5 1 2

Output:
5 3
5 4

Explanation:
Testcase1:
Input : A[] = { 2, 1, 5, 4, 3}
Output : Descending rotated with maximum element 5
Testcase2:
Input : A[] = { 3, 4, 5, 1, 2}
Output : Ascending rotated with maximum element 5
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Type_of_array {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int index = -1;
      long max = Long.MIN_VALUE;
      long[] a = new long[n];
      long[] b = new long[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextLong();
        b[i] = a[i];

        if (a[i] > max) {
          max = a[i];
          index = i;
        }
      }
      Arrays.sort(b);

      long previous = 0, next = 0;
      if (index == n - 1) {
        next = a[0];
      } else {
        next = a[index + 1];
      }
      if (index == 0) {
        previous = a[n - 1];
      } else {
        previous = a[index - 1];
      }
      int i = 0, j = 0;
      for (i = 0; i < n; i++) {
        if (a[i] != b[i]) {
          break;
        }
      }
      for (j = 0; j < n; j++) {
        if (a[j] != b[n - 1 - j]) {
          break;
        }
      }

      if (i == n) {
        System.out.println(max + " 1");
      } else if (j == n) {
        System.out.println(max + " 2");
      } else {
        if (previous > next) {
          System.out.println(max + " 4");
        } else {
          System.out.println(max + " 3");
        }
      }
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
