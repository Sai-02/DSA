/* Given an array of n distinct numbers, the task is to sort all even-placed numbers in increasing and odd-place numbers in decreasing order. The modified array should contain all sorted even-placed numbers followed by reverse sorted odd-placed numbers.
Note that the first element is considered as even because of its index 0.

Input:
The first line of input contains an integer T denoting the number of test cases. 

Then T test cases follow. Each test case contains an integer n denoting the size of the array.
 The next line contains n space separated integers forming the array.

Output:
Print the modified array which contain all sorted even placed numbers followed by reverse sorted odd placed numbers.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5

Example:
Input:
2
8
0 1 2 3 4 5 6 7
9
3 1 2 4 5 9 13 14 12

Output:
0 2 4 6 7 5 3 1
2 3 5 12 13 14 9 4 1
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Bitonic_Generator_Sort {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      ArrayList<Integer> e = new ArrayList<Integer>();
      ArrayList<Integer> o = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (i % 2 == 0) {
          e.add(k);
        } else {
          o.add(k);
        }
      }
      Collections.sort(e);
      Collections.sort(o);
      Collections.reverse(o);
      for (int i = 0; i < e.size(); i++) {
        System.out.printf("%d ", e.get(i));
      }
      for (int i = 0; i < o.size(); i++) {
        System.out.printf("%d ", o.get(i));
      }

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
