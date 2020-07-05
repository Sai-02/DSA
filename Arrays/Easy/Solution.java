/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution {

  public static void main(String[] args) throws java.lang.Exception {
    FastReader scan = new FastReader();
    int n=scan.nextInt();
    System.out.println(n);
    String s=scan.nextLine();
    System.out.println(s);
    
    

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
