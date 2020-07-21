/* Given are the heights of certain Buildings which lie adjacent to each other. 
Sunlight starts falling from left side of the buildings. 
If there is a building of certain Height, 
all the buildings to the right side of it having lesser heights cannot see the sun .
 The task is to find the total number of such buildings that receive sunlight.
Input:
First Line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines. 
 First line of each test case contains an integer N denoting the number of buildings. 
 Second line contains N space separated integers H1, H2,...HN denoting heights of buildings.

Output:
Corresponding to each test case, print the desired output in a new line

Constraints:
1<=T<=100
1<=N<=100
1<=Hi<=100

Example:
Input:
3
6
6 2 8 4 11 13
5
2 5 1 8 3
7
3 4 1 0 6 2 3

Output:
4
3
3

Explanation:
In the first example only buildings of height 6 8 11 and 13 can see the sun, hence output is 4.
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Buildings_receiving_sunlight {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int max = Integer.MIN_VALUE;
      int count = 0;
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (k >= max) {
          count++;
          max = k;
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
