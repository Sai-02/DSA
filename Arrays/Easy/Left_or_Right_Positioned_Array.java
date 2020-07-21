/*Given an array arr[] of size n>4, 
the task it to check whether the given array can be arranged in the form of Left or Right positioned array?
Left or Right Positioned Array means each element in the array is equal to the
 number of elements to its left or number of elements to its right.

Examples:

Input  : arr[] = {1, 3, 3, 2}
Output : "1"  
This array has one such arrangement {3, 1, 2, 3}. 
In this arrangement, first element '3' indicates 
that three numbers are after it, the 2nd element 
'1' indicates that one number is before it, the 
3rd element '2' indicates that two elements are 
before it.

Input : arr[] = {1, 6, 5, 4, 3, 2, 1}
Output: "0"
// No such arrangement is possible

Input : arr[] = {2, 0, 1, 3}
Output: "1"
// Possible arrangement is {0, 1, 2, 3}

Input : arr[] = {2, 1, 5, 2, 1, 5}
Output: "1"
// Possible arrangement is {5, 1, 2, 2, 1, 5}
Input:

The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is N, size of array.  
 The second line of each test case contains N input array elements.

Output:

Print 1 if array can be arranged to form left or right positioned array, else print 0.

Constraints:

1 ≤ T ≤ 100
4 < N ≤ 1000
1 ≤ arr[i] ≤ 1000

Example:

Input
2
5
1 2 3 5 0
9
1 2 3 4 0 5 6 7 8

Output
0
1
 */
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Left_or_Right_Positioned_Array {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      boolean k = true;
      int[] visited = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
        visited[i] = 0;
        if (a[i] >= n) {
          k = false;
        }
      }
      if (k) {
        for (int i = 0; i < n; i++) {
          if (visited[a[i]] == 0) {
            visited[a[i]] = 1;
          } else {
            visited[n - a[i] - 1] = 1;
          }
        }
        int i;
        for (i = 0; i < n; i++) {
          if (visited[i] == 0) {
            break;
          }
        }
        if (i == n) {
          System.out.println("1");
        } else {
          System.out.println("0");
        }
      } else {
        System.out.println("0");
      }
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
