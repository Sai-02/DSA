/*Given an array of integers arr[0..n-1],
 count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j], 0 =< i < j < n.

Example:

Input: arr[] = {5, 0, 10, 2, 4, 1, 6}

Output: 5

Explanation:
Pairs which hold condition i*arr[i] > j*arr[j] are
(10, 2) (10, 4) (10, 1) (2, 1) (4, 1)

Input:

The first line of input contains T denoting the no. of test cases .
 Then T test cases follow . 
 The first line of each test case contains an Integer N and 
 the next line contains N space separated values of the array A[ ] .


Output:
For each test case output the required result in a new line.


Constraints:
1<=T<=100
1<=N<=105
1<=A[ ] <=1000


Example:
Input:
2
7
5 0 10 2 4 1 6
4
8 4 2 1

Output:
5
2 
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Count_Pairs_in_an_Array {

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
        for (int j = i + 1; j < n; j++) {
          if (i * a[i] > j * a[j]) {
            count++;
          }
        }
      }
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
