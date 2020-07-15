/* Rahul is a geek he loves to play with array. 
He was very much bored so he asked you to solve array by selecting a pair of adjacent integers 
and remove the larger one of these two. This decreases the array size by 1. 
Cost of this operation will be equal to the smaller of them. 
Your task is to find out minimum sum of costs of operations needed to convert the array into a single element.

Input:
First line of input contains a single integer T denoting the number of test cases.
 First line of each test case starts with an integer N denoting the size of the array A.
  Next line of input contains N space separated integers, where the ith integer denotes the value Ai.

Output:
For each test case, print the minimum cost required to transform array into single element.

Constraints:
1<=T<=100
1<=N<=1000
1<=Ai<=10^5

Example:
Input:
1
3
4 2 5
Output:
4
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Rahul_a_Geek {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();

      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (min > k) {
          min = k;
        }
      }
      min = min * (n - 1);
      System.out.println(min);
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
