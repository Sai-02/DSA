/*   You start with an array A of size N.
 Also, A[i] = 0 for i = 1 to N.
  You will be given K positive integers. 
  Let j be one of these integers, 
  you have to add 1 to all A[i], for i >= j.
   Your task is to print the array A after all these K updates are done.
 

Input:
The first line of input contains an integer  T, 
denoting the number of test cases. Then T test cases follow. 
The first line of each test case consists of two space separated positive integers N and K. 
The second line consists of K space separated integers.
 

Output:
For each test case, in a new line print the array A from the first index to the last index after the K updates are done. 
utive values are to be separated by a single space between them while printing.
 

Constraints:
1<= T <=100
1<= N, K <=1000

Example:
Input:
2
3 4
1 1 2 3
2 3
1 1 1
Output:
2 3 4
3 3
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Adding_Ones {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = 0;
      }
      int K = scan.nextInt();
      for (int i = 1; i <= K; i++) {
        int j = scan.nextInt();
        for (int k = j - 1; k < n; k++) {
          a[k]++;
        }
      }
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", a[i]);
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
