/*Given an array A of positive integers.
 Count number of smaller elements on right side of each array.

Input:
The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is N,N is the size of array.
  The second line of each test case contains N input arr[i].

Output:
Print the countSmaller array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 <= Ai  <= 108

Example:
Input:
2
7
12 1 2 3 0 11 4
5
1 2 3 4 5

Output:
6 1 1 1 0 1 0
0 0 0 0 0

Explanation:
Testcase 1: 6 elements are greater than 1 on its right side in original array.
 Similarly 1 element is greater than 4 on its right side in original array.
 */
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Count_Smaller_elements {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      for (int i = 0; i < n - 1; i++) {
        int count = 0;
        for (int j = i + 1; j < n; j++) {
          if (a[i] > a[j]) {
            count++;
          }
        }
        System.out.printf("%d ", count);
      }
      System.out.printf("0");
      System.out.println();
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
