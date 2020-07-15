/* Given an array, return length of the longest subarray of non- negative integers.

Note: Subarray here means a continuous part of the array.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. 
 Each test case contains an integer n denoting the size of the array. 
 The following line contains n space separated integers forming the array.

Output:
Print the length of the longest subarray of non-negative integers.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5

Example:
Input:
2
9
2 3 4 -1 -2 1 5 6 3
10
1 0 0 1 -1 -1 0 0 1 0

Output:
4
4
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Length_of_longest_subarray {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int count = 0, max = 0;
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (k >= 0) {
          count++;
        } else {
          if (max <= count) {
            max = count;
          }
          count = 0;
        }
      }
      if (max < count) {
        max = count;
      }
      System.out.println(max);
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
