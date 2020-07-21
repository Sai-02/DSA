/* Given an array of N integers A1, A2, ….AN, count number of subarrays of A which are strictly increasing. 
A subarray Ai, j is the array where 1 <= i <= j <= N is a sequence of integers of Ai, Ai+1, ….Aj.
A subarray Ai, j is strictly increasing if Ai < Ai+1 < Ai+2 < …….

Input :
The first line contains an integer T denoting the total number of test cases.
For each test case, the first line contain an integer N denoting the number of elements in an array,
 and second line contains N elements of the array.

Output :
For each test case, output total number of strictly increasing subarrays.

Constraints:
1 <= T <= 200
1 <= N <= 107
1 <= Ai <= 107

Example:
Input:
2
6
1 3 3 2 3 5
2
1 5

Output:
4
1

Explanation:
Testcase 1: (1,3), (2, 3), (3, 5) and (2, 3, 5) are the only increasing subarrays.
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Count_increasing_Subarrays {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int count = 0, ans = 0;
      for (int i = 1; i < n; i++) {
        if (a[i - 1] < a[i]) {
          count++;
          ans = ans + count;
        } else {
          count = 0;
        }
      }
      System.out.println(ans);
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
