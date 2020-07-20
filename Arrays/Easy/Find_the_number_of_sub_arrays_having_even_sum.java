/* Given an array A[]  you have to  find the number of subarrays whose sum is an even number.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. 
The first line  of each test case contains an integer N, where N is the size of the array A[ ] .
Then Next line contains space seperated N value of the array A[ ].

Output:
For each test case in a new line, number of sub-arrays having even sum

Constraints:
1 <= T <= 200
1 <= N <= 100
1<= A[i] <=100

Example:
Input:
1
6
1 2  2  3  4 1
Output:
9

Explanation:
In the first test case the array  {1, 2, 2, 3, 4, 1} has 9 such possible subarrays-
These are-
 {1, 2, 2, 3}          Sum = 8
 {1, 2, 2, 3, 4}      Sum as  = 12
 {2}                      Sum as  = 2 (At index 1)
 {2, 2}                  Sum as Sum = 4
 {2, 2, 3, 4, 1}      Sum as = 12
 {2}                      Sum as  = 2 (At index 2)
 {2, 3, 4, 1}          Sum as = 10
 {3, 4, 1}              Sum as  = 8
 {4}                      Sum as = 4

*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Find_the_number_of_sub_arrays_having_even_sum {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }

      int result = 0;
      for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
          sum = sum + a[j];
          if (sum % 2 == 0) {
            result++;
          }
        }
      }

      System.out.println(result);
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
